package com.dimples.ui.main.book;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dimples.R;
import com.dimples.base.BaseFragment;
import com.dimples.component.ViewInject;
import com.dimples.ui.main.book.adapter.BookAdapter;
import com.dimples.ui.main.book.dto.BookDataManger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@ViewInject(LayoutId = R.layout.fragment_book)
public class BookFragment extends BaseFragment {
    @BindView(R.id.tv_title_book_1)
    TextView tvTitleBook;
    @BindView(R.id.tv_title_book_2)
    TextView tvTitleBook2;
    @BindView(R.id.iv_title_book)
    ImageView ivTitleBook;
    @BindView(R.id.ctl_book_main)
    CollapsingToolbarLayout ctlBook;
    @BindView(R.id.apl_book_main)
    AppBarLayout aplBook;
    @BindView(R.id.rl_content_main)
    RecyclerView rlContentMain;

    @Override
    public void afterBindView() {
        initRecyclerView();
        //滑动监听
        initOffsetListener();
    }

    /**
     * 列表初始化
     */
    private void initRecyclerView() {
        rlContentMain.setLayoutManager(new LinearLayoutManager(context));
        rlContentMain.setAdapter(new BookAdapter(mActivity, BookDataManger.getdData()));
    }

    /**
     * 滑动监听
     */
    private void initOffsetListener() {
        aplBook.addOnOffsetChangedListener((appBarLayout, i) -> {
            if (-i < appBarLayout.getMeasuredHeight() / 2) {
                tvTitleBook.setVisibility(View.INVISIBLE);
            } else {
                tvTitleBook.setVisibility(View.VISIBLE);
            }
        });
    }
}
















