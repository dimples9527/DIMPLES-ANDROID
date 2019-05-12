package com.dimples.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * 默认的下拉刷新管理器
 *
 * @author zhongyj
 * @date 2019/5/12
 */
public class DefaultRefreshManager extends BaseRefreshManager {


    private TextView mTvRefresh;

    public DefaultRefreshManager(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getHeaderView() {
        View inflate = mInflater.inflate(R.layout.ulti_header_layout, null, false);
        mTvRefresh = inflate.findViewById(R.id.header_text);
        return inflate;
    }

    @Override
    public void downRefresh() {
        mTvRefresh.setText("下拉刷新");
    }

    @Override
    public void releaseRefresh() {
        mTvRefresh.setText("释放刷新");
    }

    @Override
    public void idleRefresh() {
        mTvRefresh.setText("下拉刷新");
    }

    @Override
    public void refreshing() {
        mTvRefresh.setText("正在刷新");
    }

}













