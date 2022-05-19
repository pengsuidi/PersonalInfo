package com.amaker.personalinfo.Fragment_NavigationUI.HistoryOrders;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.amaker.personalinfo.R;
import com.amaker.personalinfo.adapter.order_shop_Adapter;
import com.amaker.personalinfo.entity.Result;


import com.amaker.personalinfo.entity.payment;
import com.amaker.personalinfo.util.Config;
import com.amaker.personalinfo.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.droidsonroids.gif.GifImageView;


public class HistoryOrdersFragment extends Fragment {
    private RecyclerView.Adapter adapter;
    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private List<payment> datas = new ArrayList<>();//用OID来区分每个数据,OID不重复
    private List<payment> Alldatas = new ArrayList<>();//接收后端传来的所有数据
    private int inoid=-1;
    private GifImageView gifView;

    private Handler handler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.STATUS_OK://网络请求成功，但响应需要根据实际来操作
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    System.out.println("result:---" + result);
                    if (result.getCode() == Config.STATUS_SUCCESS) {
                        //网络请求成功
                        JSONArray jsonArray = (JSONArray) result.getData();
                        List<payment> payments = jsonArray.toJavaList(payment.class);
                       System.out.println("个数:" + payments.size());
                        datas.clear();
                        Alldatas.clear();
                        Alldatas.addAll(payments);

                        for (int i = 0; i < payments.size(); i++) {
                            if(payments.get(i).getOid()!=inoid)//只把不同oid的数据纳入datas中
                            {
                                inoid=payments.get(i).getOid();
                                System.out.println("--------inoid:"+inoid);

                                datas.add(payments.get(i));//datas为每个订单只有一行数据

                            }
                        }

                        adapter.notifyDataSetChanged();
                        gifView.setVisibility(View.INVISIBLE);
                        break;
                    }
                default://网络请求失败

                    break;
            }
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_order,container,false);
        recyclerView =view.findViewById(R.id.recycler_orders);
        sharedPreferences=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new order_shop_Adapter(datas,sharedPreferences, getActivity(),Alldatas);
        recyclerView.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, Object> params = new HashMap<>();
                params.put(Config.REQUEST_PARAMETER_USER_ID, sharedPreferences.getString(Config.REQUEST_PARAMETER_USER_ID,null));//userid暂定为1
                System.out.println("userid:"+sharedPreferences.getString(Config.REQUEST_PARAMETER_USER_ID,null));
                OkHttpUtil.post(Config.URL_GET_ORDERS, params, handler);
            }
        }).start();
        //设置动画
        gifView =  view.findViewById(R.id.gif_view);
        gifView.setImageResource(R.drawable.loading);
        gifView.setStateListAnimator(null);
        gifView.setVisibility(View.VISIBLE);

        return view;
    }
    public Bitmap getBitmapFromByte(byte[] temp) {   //将二进制转化为bitmap
        if (temp != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(temp, 0, temp.length);
            return bitmap;
        } else {
            return null;
        }
    }

}