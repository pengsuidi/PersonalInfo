package com.amaker.personalinfo.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amaker.personalinfo.R;
import com.amaker.personalinfo.adapter.SearchResultAdapter;
import com.amaker.personalinfo.entity.Result;
import com.amaker.personalinfo.entity.Shop;
import com.amaker.personalinfo.entity.Shop_Info;
import com.amaker.personalinfo.util.CommonUtil;
import com.amaker.personalinfo.util.Config;
import com.amaker.personalinfo.util.OkHttpUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SearchActivity extends Activity implements View.OnClickListener {
    private SearchView searchView;
    private ImageButton back;
    private Button click_search;
    private RecyclerView recyclerview_search;
    private RecyclerView.Adapter adapter;
    private String queryString;
    private List<Shop_Info> ShopInfoList = new ArrayList<>();
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Config.STATUS_OK:
                    Result result = JSONObject.parseObject(msg.obj.toString(), Result.class);
                    JSONArray jsonArray = (JSONArray) result.getData();
                    List<Shop_Info> datas = jsonArray.toJavaList(Shop_Info.class);
                    datas = removeDuplicateWithShopID(datas);

                    ShopInfoList.clear();
                    ShopInfoList.addAll(datas);
                    adapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initUI();
        initFunction();
    }

    private void initFunction() {
        click_search.setOnClickListener(this);
        back.setOnClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                queryString = query;
                //软件盘的搜索按钮点击就是在这里走的逻辑
                //点击搜索
                //获取搜索内容
                SendQuery(queryString);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //输得内容改变的方法监听
                return false;
            }
        });

    }

    private void SendQuery(String queryString) {
        Map<String, Object> map = new HashMap<>();
        map.put(Config.REQUEST_QUERY_STRING, queryString);
        OkHttpUtil.post(Config.URL_GET_QUERY_RES, map, handler);

    }

    private void initUI() {
        searchView = findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(false);
        recyclerview_search = findViewById(R.id.recyclerview_search);
        back = findViewById(R.id.back);
        click_search = findViewById(R.id.click_search);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview_search.setLayoutManager(linearLayoutManager);
        adapter = new SearchResultAdapter(ShopInfoList);
        recyclerview_search.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.click_search:
                SendQuery(searchView.getQuery().toString());
                break;

        }
    }
    public  List<Shop_Info> removeDuplicateWithShopID(List<Shop_Info>  list) {
        Set set = new HashSet();
        List<Shop_Info> newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext();) {
            Shop_Info element = (Shop_Info) iter.next();
            if (set.add(element.getShop_id()))
                newList.add(element);
        }
        return newList;
    }
}
