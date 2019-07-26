package com.example.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import com.bumptech.glide.util.LogTime;
import com.example.bean.Bean;
import com.example.bean.DbBean;
import com.example.bean.UTILSSSS;
import com.example.demo2.R;

import java.util.ArrayList;
import java.util.List;

public class GouAdapter extends RecyclerView.Adapter<GouAdapter.ViewHolder> {
    List<Bean.DataBean> list = new ArrayList<>();
    private Context context;
    List<Boolean> booleanList = new ArrayList<>();

    public GouAdapter(Context context) {
        this.context = context;
    }


    public void initdata( List<Bean.DataBean> list ){
        this.list.addAll(list);
        for (int i = 0; i < list.size(); i++) {
            booleanList.add(false);
        }
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.layout_item, null);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.iv);
        viewHolder.title.setText(list.get(i).getTitle());
        viewHolder.pei.setText("配料："+list.get(i).getFood_str());
        viewHolder.jia.setText("价格："+list.get(i).getNum());
        String title = list.get(i).getTitle();
        Log.d("TTTTT", "onBindViewHolder: "+title);
        DbBean queryone = UTILSSSS.queryone(list.get(i).getTitle());
        if (queryone != null) {
            booleanList.set(i, true);
        }else {
            booleanList.set(i, false);
        }
        final Boolean aBoolean = booleanList.get(i);
        if (aBoolean) {
            viewHolder.cb.setChecked(true);
        } else {
            viewHolder.cb.setChecked(false);
        }
        viewHolder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  dataBean.setChecked(!dataBean.isChecked());
                if (aBoolean) {
                    booleanList.set(i, false);
                    String id = list.get(i).getTitle();
                    DbBean queryone = UTILSSSS.queryone(list.get(i).getTitle());
                    UTILSSSS.delete(queryone);
                    Toast.makeText(context, "已删除", Toast.LENGTH_SHORT).show();

                } else {
                    booleanList.set(i, true);
                    DbBean dbBean = new DbBean();
                    dbBean.setTitle(list.get(i).getTitle());
                    UTILSSSS.insert(dbBean);
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

        private final CheckBox cb;
        private final ImageView iv;
        private final TextView title;
        private final TextView pei;
        private final TextView jia;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cb = itemView.findViewById(R.id.cb);
            iv = itemView.findViewById(R.id.iv);
            title = itemView.findViewById(R.id.title);
            pei = itemView.findViewById(R.id.pei);
            jia = itemView.findViewById(R.id.jia);
        }
    }
    public void setChangeListener(ChangeListener changeListener) {
        mChangeListener = changeListener;
    }

    ChangeListener mChangeListener;

    public interface ChangeListener {
        void onClient(Bean.DataBean dataBean,CheckBox checkBox);
    }
}
