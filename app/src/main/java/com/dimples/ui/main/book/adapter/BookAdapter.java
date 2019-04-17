package com.dimples.ui.main.book.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dimples.R;
import com.dimples.ui.main.book.bean.BookBean;
import com.dimples.ui.main.book.view.BookDetailActivity;

import java.util.List;

/**
  *
  * @author zhongyj
  * @date 2019/3/29 12:23
  */
public class BookAdapter extends RecyclerView.Adapter {

    private List<BookBean> data;
    private Activity mActivity;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public BookAdapter(Activity activity, List<BookBean> data) {
        recycledViewPool = new RecyclerView.RecycledViewPool();
        this.mActivity = activity;
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
        } else if (i == BookBean.IBookItemType.HORIZONTAL) {
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
            //传递数据，保存数据到View中,通过view.getTag()获取
            ((BookViewHolder) viewHolder).itemView.setTag(i);
        } else if (viewHolder instanceof BookViewHolderH) {
            RecyclerView recyclerView = ((BookViewHolderH) viewHolder).recyclerView;
            recyclerView.setAdapter(new BookAdapter(mActivity, bookBean.getData()));
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
            //点击事件绑定
            this.itemView.setOnClickListener(v -> BookDetailActivity.start50(mActivity, textView));
        }
    }

    class BookViewHolderH extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        BookViewHolderH(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rc_item_book_h);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
            //显示条目创建优化
            layoutManager.setRecycleChildrenOnDetach(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setRecycledViewPool(recycledViewPool);

        }
    }
}













