package com.amaker.personalinfo.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amaker.personalinfo.R;
import com.amaker.personalinfo.entity.Result;
import com.amaker.personalinfo.entity.order_shop;
import com.amaker.personalinfo.entity.payment;
import com.amaker.personalinfo.util.CommonUtil;
import com.amaker.personalinfo.util.Config;

import java.util.List;

public class HistoryFoodOrdersAdapter extends RecyclerView.Adapter<HistoryFoodOrdersAdapter.BoughtFoodViewHolder> {

    private List<payment> datas;



    public HistoryFoodOrdersAdapter(List<payment> datas ) {
        this.datas = datas;
      }

    /**
     * 加载 ViewHolder 对象
     */
    @NonNull
    @Override
    public BoughtFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //此处的 布局文件.xml 是每条数据的展示效果布局样式图
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bought_food, null, false);
        return new BoughtFoodViewHolder(view);
    }

    /**
     * TODO 绑定数据及事件
     */
    @Override
    public void onBindViewHolder(@NonNull final BoughtFoodViewHolder holder, int position) {
        final payment payment = datas.get(position);
        holder.food_price.setText("¥"+payment.getFood_price());
        System.out.println("user_id:"+payment.getUser_id());
        holder.food_name.setText(payment.getFood_name());

        Bitmap tmp = getBitmapFromByte(payment.getFood_image());
        tmp = Bitmap.createScaledBitmap(tmp, 45, 45, true);
        tmp = CommonUtil.getRoundedCornerBitmap(tmp, 20);
        holder.imageview.setImageBitmap(tmp);
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
    class BoughtFoodViewHolder extends RecyclerView.ViewHolder {

        private TextView food_name, food_price;
        private ImageView imageview;


        public BoughtFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.food_name);
            food_price = itemView.findViewById(R.id.food_price);
            imageview = itemView.findViewById(R.id.imageview);


        }
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
