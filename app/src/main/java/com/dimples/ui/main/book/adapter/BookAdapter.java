package com.dimples.ui.main.book.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dimples.R;
import com.dimples.ui.main.book.dto.BookBean;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {

    private List<BookBean> data;
    private Context context;

    public BookAdapter(Context context, List<BookBean> data) {
        this.context = context;
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
        if (i == BookBean.IBookItemType.VERTICAL) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_fragment, null);
            return new BookViewHolder(inflate);
        } else if (i == BookBean.IBookItemType.HORIZANTAL) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_fragment_h, null);
            return new BookViewHolderH(inflate);
        }
        return new BookViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_fragment, null));
    }

    /**
     * 绑定数据
     *
     * @param viewHolder RecyclerView.ViewHolder
     * @param i          int
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BookBean bookBean = data.get(i);
        if (viewHolder instanceof BookViewHolder) {
            ((BookViewHolder) viewHolder).textView.setText(bookBean.getDesc());
        } else if (viewHolder instanceof BookViewHolderH) {
            RecyclerView recyclerView = ((BookViewHolderH) viewHolder).recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            recyclerView.setAdapter(new BookAdapter(context,bookBean.getData()));
        }
    }

    /**
     * 得到数据总数
     *
     * @return int
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getItemType();
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        BookViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_item_book);
        }
    }

    class BookViewHolderH extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        BookViewHolderH(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rc_item_book_h);
        }
    }
}













