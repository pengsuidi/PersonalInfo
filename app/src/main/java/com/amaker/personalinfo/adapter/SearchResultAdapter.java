package com.amaker.personalinfo.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amaker.personalinfo.Activities.ShopActivity;
import com.amaker.personalinfo.R;
import com.amaker.personalinfo.entity.Shop_Info;
import com.amaker.personalinfo.util.Config;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {
    private List<Shop_Info> datas;
    public SearchResultAdapter(List<Shop_Info> datas) {
        this.datas = datas;
    }
    /**
     * 加载 ViewHolder 对象
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //此处的 布局文件.xml 是每条数据的展示效果布局样式图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seach_res, parent, false);
        return new ViewHolder(view);
    }

    /**
     * TODO 绑定数据及事件
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Shop_Info shop_info = datas.get(position);
        //   SharedPreferences.Editor editor= getSharedPreferences("data",MODE_PRIVATE).edit();
        holder.res.setText(shop_info.getShop_name());
        holder.res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ShopActivity.class);
                intent.putExtra(Config.REQUEST_PARAMETER_SHOP_ID,shop_info.getShop_id().toString());
                v.getContext().startActivity(intent);
            }
        });


    }

    /**
     * 告知 RecyclerView 子项（item） 的数量
     */
    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    /**
     * ViewHolder 对象，是 RecyclerView 中对 ITEM 循环利用的一个机制
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        private Button res;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            res = itemView.findViewById(R.id.search_item);
        }
    }


}
