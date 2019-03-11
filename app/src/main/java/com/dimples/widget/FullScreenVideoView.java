package com.dimples.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * 自定义视频播放控件，实现视频的全屏播放
 *
 * @author zhongyj
 * @date 2019/3/11 14:27
 */
public class FullScreenVideoView extends VideoView {
    /**
     * 主要是用于这个直接new出来的对象
     *
     * @param context Context
     */
    public FullScreenVideoView(Context context) {
        super(context);
    }

    /**
     * 主要用于xml文件中,支持自定义属性
     *
     * @param context Context
     * @param attrs   AttributeSet
     */
    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 主要用于xml文件中,支持自定义属性和样式
     *
     * @param context      Context
     * @param attrs        AttributeSet
     * @param defStyleAttr int
     */
    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}














