package com.example.checkboxtest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.checkboxtest.R;
import com.example.checkboxtest.bean.Bean;
import com.example.checkboxtest.bean.DbBean;
import com.example.checkboxtest.utils.DbUtil;

import org.greenrobot.greendao.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class GouAdapter extends RecyclerView.Adapter<GouAdapter.ViewHolder> {
    private ArrayList<Bean.DataBean> list;
    private Context context;
    private List<Boolean> status = new ArrayList<>();
    List<Boolean> booleanList = new ArrayList<>();

    public GouAdapter(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        for (int i = 0; i < list.size(); i++) {
            booleanList.add(false);
        }
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.layout_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final Bean.DataBean dataBean = list.get(i);
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.iv);
        viewHolder.title.setText("菜名："+list.get(i).getTitle());
        viewHolder.pei.setText("配料："+list.get(i).getFood_str());
        viewHolder.jia.setText("价格："+list.get(i).getNum());
        DbBean queryone = DbUtil.getDbUtil().queryone(list.get(i).getTitle());
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
                    DbBean querttitle = DbUtil.getDbUtil().queryone(id);
                    DbUtil.getDbUtil().delete(querttitle);
                    Toast.makeText(context, "已删除", Toast.LENGTH_SHORT).show();

                } else {
                    booleanList.set(i, true);
                    DbBean dbBean = new DbBean();
                    dataBean.setTitle(list.get(i).getTitle());
                    DbUtil.getDbUtil().insert(dbBean);
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
