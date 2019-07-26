package com.liangxq.mydemo1.adapers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liangxq.mydemo1.R;
import com.liangxq.mydemo1.bean.ListData;

import java.util.ArrayList;
import java.util.List;

public class RecycAdaper extends RecyclerView.Adapter<RecycAdaper.ViewHolder> {

    List<ListData> list = new ArrayList<>();
    Context context;

    public RecycAdaper(Context context) {
        this.context = context;
    }

    public void initdata(List<ListData> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.recyc_layout, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name=  itemView.findViewById(R.id.name);
        }
    }
}
