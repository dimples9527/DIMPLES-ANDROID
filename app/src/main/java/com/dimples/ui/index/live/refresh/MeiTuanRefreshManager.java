package com.dimples.ui.index.live.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.dimples.R;
import com.dimples.widget.refresh.BaseRefreshManager;

/**
 * @author zhongyj
 * @date 2019/5/14
 */
public class MeiTuanRefreshManager extends BaseRefreshManager {

    private ImageView mMeiTuanImageViewLoading;

    public MeiTuanRefreshManager(Context context) {
        super(context);
    }

    @SuppressLint("InflateParams")
    @Override
    public View getHeaderView() {
        View inflate = mInflater.inflate(R.layout.meituan_header_refresh_layout, null, false);
        mMeiTuanImageViewLoading = inflate.findViewById(R.id.mei_tuan_loading);
        return inflate;
    }

    /**
     * 触发一次
     */
    @Override
    public void downRefresh() {

    }

    /**
     * 释放刷新的时候，会变成美团的吉祥物
     */
    @Override
    public void releaseRefresh() {
        //帧动画效果
        mMeiTuanImageViewLoading.setImageResource(R.drawable.mei_tuan_loading_pre);
        AnimationDrawable drawable = (AnimationDrawable) mMeiTuanImageViewLoading.getDrawable();
        drawable.start();
    }

    @Override
    public void idleRefresh() {
        mMeiTuanImageViewLoading.clearAnimation();
        mMeiTuanImageViewLoading.setImageResource(R.mipmap.pull_image);
        mMeiTuanImageViewLoading.setScaleX(0);
        mMeiTuanImageViewLoading.setScaleY(0);
    }

    /**
     * 正在刷新的动画，也是一个帧动画
     */
    @Override
    public void refreshing() {
        mMeiTuanImageViewLoading.setImageResource(R.drawable.mei_tuan_loading);
        AnimationDrawable drawable = (AnimationDrawable) mMeiTuanImageViewLoading.getDrawable();
        drawable.start();
    }

    @Override
    public void downRefreshPercent(float percent) {
        //设置显示图片的大小，实现缩放效果
        mMeiTuanImageViewLoading.setScaleX(percent);
        mMeiTuanImageViewLoading.setScaleY(percent);
    }
}

















