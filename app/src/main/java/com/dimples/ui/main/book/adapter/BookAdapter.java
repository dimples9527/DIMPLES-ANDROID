package com.dimples.ui.main.book.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dimples.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {

    private List<String> adapterListData;

    public BookAdapter(List<String> data) {
        adapterListData = data;
    }

    /**
     * 创建View 进行缓存
     * @param viewGroup ViewGroup
     * @param i int
     * @return RecyclerView.ViewHolder
     */
    @NonNull
    @SuppressLint("InflateParams")
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_fragment, null);
        return new BookViewHolder(inflate);
    }

    /**
     * 绑定数据
     * @param viewHolder RecyclerView.ViewHolder
     * @param i int
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        String s = adapterListData.get(i);
        ((BookViewHolder) viewHolder).textView.setText(s);
    }

    /**
     * 得到数据总数
     * @return int
     */
    @Override
    public int getItemCount() {
        return adapterListData.size();
    }


    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        BookViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_book);
        }
    }
}













