package com.example.zhusimengzsm.adapers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhusimengzsm.R;
import com.example.zhusimengzsm.bean.Bean1;

import java.util.ArrayList;
import java.util.List;

public class RecycAdaper extends RecyclerView.Adapter<RecycAdaper.ViewHolder> {

    List<Bean1.ResultBean.DataBean> list = new ArrayList<>();
    Context context;

    public RecycAdaper(Context context) {
        this.context = context;
    }


    public void getdata(List<Bean1.ResultBean.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.recyc_item_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(i).getThumbnail_pic_s()).apply(requestOptions).into(viewHolder.imageView);

        viewHolder.name1.setText(list.get(i).getAuthor_name());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=  itemView.findViewById(R.id.img1);
            name1=   itemView.findViewById(R.id.name1);
        }
    }
}
