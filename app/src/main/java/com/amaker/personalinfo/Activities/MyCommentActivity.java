package com.amaker.personalinfo.Activities;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amaker.personalinfo.R;
import com.amaker.personalinfo.adapter.UserCommentsAdapter;
import com.amaker.personalinfo.entity.Result;
import com.amaker.personalinfo.entity.Shop_Info;
import com.amaker.personalinfo.entity.User;
import com.amaker.personalinfo.entity.UserComment;
import com.amaker.personalinfo.util.CommonUtil;
import com.amaker.personalinfo.util.Config;
import com.amaker.personalinfo.util.OkHttpUtil;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCommentActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView user_img;
    private TextView comment_count,user_name;
    private Bitmap userBitmap;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<UserComment> comments = new ArrayList<>();
    private List<Shop_Info> Shoplist=new ArrayList<>();
    private String userid;;
    private int count=0;
    private User user=new User();
    private Handler msg_handler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
            //接收adapter的消息
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.DELETE://网络请求成功，但响应需要根据实际来操作
                    System.out.println("msg.obj:"+msg.obj);
                    int position=(int)msg.obj;
                    Shoplist.remove(position);
                    comments.remove(position);
                    adapter.notifyDataSetChanged();
                    count--;
                    comment_count.setText("评价"+count);
                    break;
                default:
                    break;
            }
        }
    };
    private Handler handler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.STATUS_OK://网络请求成功，但响应需要根据实际来操作
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    if (result.getCode() == Config.STATUS_SUCCESS) {
                        //网络请求成功
                        JSONArray jsonArray = (JSONArray) result.getData();
                        List<UserComment> datas = jsonArray.toJavaList(UserComment.class);
                        System.out.println("个数:" + datas.size());
                        comments.clear();
                        comments.addAll(datas);
                        count=datas.size();
                        comment_count.setText("评价"+count);
                        for(int i=0;i<comments.size();i++)
                        {
                            Shop_Info shop_info=new Shop_Info();
                            shop_info.setShop_id(comments.get(i).getShop_id());
                            Shoplist.add(shop_info);
                            Map<String, Object> param = new HashMap<>();
                            param.put(Config.REQUEST_PARAMETER_SHOP_ID, comments.get(i).getShop_id());
                            OkHttpUtil.post(Config.URL_GetShopInfoByShopidServlet, param, newhandler);
                        }

                        break;
                    }
                default://网络请求失败

                    break;
            }
        }
    };
    private Handler newhandler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.STATUS_OK://网络请求成功，但响应需要根据实际来操作
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    JSONObject object = (JSONObject) result.getData();
                    Shop_Info ShopInfo = object.toJavaObject(Shop_Info.class);
                    for(int i=0;i<Shoplist.size();i++)
                    {
                        if(ShopInfo.getShop_id()==Shoplist.get(i).getShop_id())
                        {
                           Shoplist.get(i).setShop_image(ShopInfo.getShop_image());
                           Shoplist.get(i).setShop_img_addr(ShopInfo.getShop_img_addr());
                           Shoplist.get(i).setShop_name(ShopInfo.getShop_name());
                           Shoplist.get(i).setUser_id(ShopInfo.getUser_id());

                        }
                    }
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }

        }
    };
    private Handler InitUserHandler = new Handler(Looper.myLooper()) {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Config.STATUS_OK://网络请求成功，但响应需要根据实际来操作
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    JSONObject object = (JSONObject) result.getData();
                    user = object.toJavaObject(User.class);
                    tmp = CommonUtil.getBitmapFromByte(user.getUser_img());
                    userBitmap= Bitmap.createScaledBitmap(tmp,150,150,true);
                    userBitmap= CommonUtil.getRoundedCornerBitmap(userBitmap,30);
                    user_img.setImageBitmap(userBitmap);
                    user_img.setImageBitmap(tmp);
                    user_name.setText(user.getUnickname());
                    //adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }

        }
    };
    private Bitmap tmp;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        InitData();

    }

    private void InitData() {

        //获得该用户ID的商家评论
        Map<String, Object> map = new HashMap<>();
        map.put(Config.REQUEST_PARAMETER_USERID, userid);
        OkHttpUtil.post(Config.URL_GetPersonCommentsServlet, map, handler);
        //获得该用户的图片
        Map<String, Object> param = new HashMap<>();
        param.put(Config.REQUEST_PARAMETER_USERID, userid);
        OkHttpUtil.post(Config.URL_GetUserInfo, param, InitUserHandler);

    }

    private void initView() {
        setContentView(R.layout.activity_mycomment);
        user_img=findViewById(R.id.user_img);
        user_name=findViewById(R.id.user_name);
        userid=getSharedPreferences("data", MODE_PRIVATE).getString(Config.REQUEST_PARAMETER_USERID, null);
        toolbar = findViewById(R.id.toolbar);
        comment_count = findViewById(R.id.comment_count);
        toolbar.setTitle("用户:"+userid);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView = findViewById(R.id.recycler_comments);
        adapter = new UserCommentsAdapter(comments,Shoplist,this,msg_handler);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyCommentActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
}
