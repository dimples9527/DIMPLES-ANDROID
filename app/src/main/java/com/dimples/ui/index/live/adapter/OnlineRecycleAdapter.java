package com.dimples.ui.index.live.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dimples.R;
import com.dimples.ui.index.book.bean.TreatPatientBean;
import com.dimples.ui.index.book.bean.TreatPatientResultBean;

/**
 * @author zhongyj
 * @date 2019/3/29 12:23
 */
public class OnlineRecycleAdapter extends RecyclerView.Adapter {

    private TreatPatientResultBean data;

    public OnlineRecycleAdapter(TreatPatientResultBean data) {
        this.data = data;
    }

    /**
     * 创建View 进行缓存
     *
     * @param viewGroup ViewGroup
     * @param i         int
     * @return RecyclerView.ViewHolder
     */
    @NonNull
    @SuppressLint("InflateParams")
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_fragment, null);
        return new OnlineViewHolder(inflate);
    }

    /**
     * 绑定数据
     *
     * @param viewHolder RecyclerView.ViewHolder
     * @param i          int
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TreatPatientBean patientBean = data.getData().get(i);
        ((OnlineViewHolder) viewHolder).textView.setText(patientBean.getPatientName());
    }

    /**
     * 得到数据总数
     *
     * @return int
     */
    @Override
    public int getItemCount() {
        return data.getData().size();
    }


    class OnlineViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        OnlineViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_book);
            //点击事件绑定
        }
    }

}













