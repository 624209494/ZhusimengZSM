package com.example.check_1.adapers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.check_1.Bean;
import com.example.check_1.R;


import java.util.ArrayList;
import java.util.List;

public class RecycAdaper extends RecyclerView.Adapter<RecycAdaper.ViewHolder> {

    List<Bean.DataBean>  list  = new ArrayList<>();
    Context context;
    List<Boolean>  booleanList = new ArrayList<>();
    boolean isbool;
    public List<Boolean> getBooleanList() {
        return booleanList;
    }




    public RecycAdaper(Context context) {
        this.context = context;
    }


    public void initdata( List<Bean.DataBean>  list ){
        this.list.addAll(list);
        for (int i = 0; i < list.size(); i++) {
             booleanList.add(false);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
     //   View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyc_item_layout,null);
        View inflate1 = View.inflate(context, R.layout.recyc_item_layout, null);

        return new ViewHolder(inflate1);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tv.setText(list.get(i).getTitle());
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).load(list.get(i).getPic()).apply(requestOptions).into(viewHolder.img1);


        final Boolean aBoolean = booleanList.get(i);
        if (aBoolean){
            viewHolder.checkBox.setChecked(true);
        }else {
            viewHolder.checkBox.setChecked(false);
        }

        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aBoolean){
                    booleanList.set(i,false);
                }else {
                    booleanList.set(i,true);
                }
                notifyDataSetChanged();
            }

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        ImageView img1;
        TextView  tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=   itemView.findViewById(R.id.cb);
            img1= itemView.findViewById(R.id.img1);
            tv=  itemView.findViewById(R.id.tv1);
        }
    }
}
