package com.example.demo1.adapers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.demo1.R;
import com.example.demo1.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class RecycAdaper extends RecyclerView.Adapter<RecycAdaper.ViewHolder> {

    List<Bean.ResultsBean>  list  = new ArrayList<>();
    Context context;

    public RecycAdaper(Context context) {
        this.context = context;
    }


    public void initdata( List<Bean.ResultsBean>  list ){
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyc_item1_layout, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getWho());
        viewHolder.times.setText(list.get(i).getDesc());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();

        Glide.with(context).load(list.get(i).getUrl()).apply(requestOptions).into(viewHolder.img1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView  name;
        TextView  times;
        ImageView img1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=   itemView.findViewById(R.id.name);
            img1= itemView.findViewById(R.id.img1);
            times=  itemView.findViewById(R.id.times);
        }
    }
}
