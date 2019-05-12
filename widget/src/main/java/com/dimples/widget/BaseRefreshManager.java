package com.dimples.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author zhongyj
 * @date 2019/5/12
 */
public abstract class BaseRefreshManager {

    public final LayoutInflater mInflater;

    public BaseRefreshManager(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 获取下拉刷新效果
     *
     * @return View
     */
    public abstract View getHeaderView();

    /**
     * 下拉刷新
     */
    public abstract void downRefresh();

    /**
     * 释放刷新
     */
    public abstract void releaseRefresh();

    /**
     * 静止
     */
    public abstract void idleRefresh();

    /**
     * 正在刷新
     */
    public abstract void refreshing();
}














