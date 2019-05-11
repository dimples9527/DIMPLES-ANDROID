package com.dimples.ui.index.live.design;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * @author zhongyj
 * @date 2019/4/18 17:58
 */
public class BottomShowBehavior extends CoordinatorLayout.Behavior<TextView> {

    public BottomShowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 方法的回调时机，即将发生嵌套滚动
     *
     * @param coordinatorLayout CoordinatorLayout
     * @param child             TextView
     * @param directTargetChild View
     * @param target            View
     * @param axes              int
     * @param type              用于判断滑动的方向
     * @return Boolean
     */
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return type == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    /**
     * 发生嵌套滚动时回调
     *
     * @param coordinatorLayout coordinatorLayout
     * @param child             child
     * @param target            target
     * @param dxConsumed        dxConsumed
     * @param dyConsumed        dxConsumed
     * @param dxUnconsumed      dxUnconsumed
     * @param dyUnconsumed      dxUnconsumed
     * @param type              type
     */
    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        //向下滑动
        if (dyConsumed + dyUnconsumed > 0) {
            //隐藏child
            if (child.getVisibility() == View.VISIBLE) {
                BottomAnim.hide(child);
            }
        } else {    //向下滑动
            //展示child
            if (child.getVisibility() != View.VISIBLE) {
                BottomAnim.show(child);
            }
        }
    }
}
























