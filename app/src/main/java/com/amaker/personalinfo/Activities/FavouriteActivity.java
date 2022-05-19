package com.amaker.personalinfo.Activities;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amaker.personalinfo.R;
import com.amaker.personalinfo.adapter.FavouriteAdapter;
import com.amaker.personalinfo.entity.Result;

import com.amaker.personalinfo.entity.Shop_Info;
import com.amaker.personalinfo.util.Config;
import com.amaker.personalinfo.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavouriteActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private List<Shop_Info> datas = new ArrayList<>();

    private Handler inithandler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.STATUS_OK://网络请求成功，但响应需要根据实际来操作
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    if (result.getCode() == Config.STATUS_SUCCESS) {
                        //网络请求成功
                        System.out.println("result:" + result);
                        JSONArray jsonArray = (JSONArray) result.getData();
                        List<Shop_Info> list = jsonArray.toJavaList(Shop_Info.class);
                        System.out.println("个数:" + list.size());
                        datas.clear();
                        datas.addAll(list);

                        adapter.notifyDataSetChanged();
                        break;
                    }
                    else
                        break;



                default:
                    break;
            }

        }
    };
    private boolean IfEdit=true;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        initData();
        init();
        initFunction();

    }

    private void initData() {
        //获得用户的收藏夹
        Map<String, Object> param = new HashMap<>();
        param.put(Config.REQUEST_PARAMETER_USERID, getSharedPreferences("data", MODE_PRIVATE).getString(Config.REQUEST_PARAMETER_USERID, null));
        OkHttpUtil.post(Config.URL_GET_FAVOURITE_LIST, param, inithandler);

    }

    private void initFunction() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.edit:
                        if(IfEdit)
                        {
                            item.setTitle("完成");
                            IfEdit=false;
                        }
                            else
                        {
                            item.setTitle("编辑");
                            IfEdit=true;
                        }

                        break;
                }
                return false;
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new FavouriteAdapter(datas);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }


    private void init() {
        recyclerView = findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);
    }
}
