package com.dimples.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * 下拉刷新布局
 *
 * @author zhongyj
 * @date 2019/5/12
 */
public class RefreshLayout extends LinearLayout {

    private static final String D_TAG = "D-RefreshLayout";
    private BaseRefreshManager mRefreshManager;
    private Context mContext;
    private View mHeaderView;
    /**
     * 头部的最小高度
     */
    private int mMinHeaderViewHeight;
    /**
     * 头部布局最大高度
     */
    private int mMaxHeaderViewHeight;
    /**
     * 正在刷新回调接口
     */
    private RefreshListener mRefreshListener;

    public RefreshLayout(Context context) {
        super(context);
        initView(context);
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public RefreshLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    private void initView(Context context) {
        mContext = context;
    }

    /**
     * 开启下拉刷新  下拉刷新的效果是默认的
     */
    public void setRefreshManager() {
        mRefreshManager = new DefaultRefreshManager(mContext);
        initHeaderView();
    }

    /**
     * 开启下拉刷新  使用用户自定义的下拉刷新效果
     *
     * @param manager BaseRefreshManager
     */
    public void setRefreshManager(BaseRefreshManager manager) {
        mRefreshManager = manager;
        initHeaderView();
    }

    private void initHeaderView() {
        setOrientation(VERTICAL);
        mHeaderView = mRefreshManager.getHeaderView();
        mHeaderView.measure(0, 0);
        int headerViewHeight = mHeaderView.getMeasuredHeight();
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, headerViewHeight);
        mMinHeaderViewHeight = -headerViewHeight;
        mMaxHeaderViewHeight = (int) (headerViewHeight * 0.3f);
        params.topMargin = mMinHeaderViewHeight;
        addView(mHeaderView, 0, params);
    }

    /**
     * 完成刷新
     */
    public void refreshOver() {
        hideHeadView(getHeadViewLayoutParams());
    }

    /**
     * 自定义回调接口
     */
    public void setRefreshListener(RefreshListener refreshListener) {
        this.mRefreshListener = refreshListener;
    }

    public interface RefreshListener {
        /**
         * 刷新中回调方法
         */
        void onRefreshing();
    }


    private int downY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = (int) event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) event.getY();
                int dy = moveY - downY;
                Log.i(D_TAG, "onTouchEvent: " + dy);
                if (dy > 0) {
                    LayoutParams params = getHeadViewLayoutParams();
                    //添加阻尼效果  （ /1.8f ）
                    int topMargin = (int) Math.min(dy / 1.8f + mMinHeaderViewHeight, mMaxHeaderViewHeight);
                    //设置控件的状态
                    if (topMargin < 0 && mCurrentRefreshState != RefreshState.DOWN_REFRESH) {
                        mCurrentRefreshState = RefreshState.DOWN_REFRESH;
                        //提示下拉刷新的状态
                        handRefreshState(mCurrentRefreshState);
                    } else if (topMargin >= 0 && mCurrentRefreshState != RefreshState.RELEASE_REFRESH) {
                        mCurrentRefreshState = RefreshState.RELEASE_REFRESH;
                        //提示是否刷新的状态
                        handRefreshState(mCurrentRefreshState);
                    }
                    params.topMargin = topMargin;
                    mHeaderView.setLayoutParams(params);
                }
                return true;
            case MotionEvent.ACTION_UP:
                if (handleEventUp()) {

                    return true;
                }
                break;
            default:
                break;
        }
        performClick();
        return super.onTouchEvent(event);
    }

    /**
     * 判断手指松开时是否应该处理
     *
     * @return boolean
     */
    private boolean handleEventUp() {
        final LayoutParams params = getHeadViewLayoutParams();
        if (mCurrentRefreshState == RefreshState.DOWN_REFRESH) {
            //隐藏刷新动画
            hideHeadView(params);
        } else if (mCurrentRefreshState == RefreshState.RELEASE_REFRESH) {
            //保持刷新的状态
            params.topMargin = 0;
            mHeaderView.setLayoutParams(params);
            mCurrentRefreshState = RefreshState.REFRESHING;
            handRefreshState(mCurrentRefreshState);
            if (mRefreshListener != null) {
                mRefreshListener.onRefreshing();
            }
        }
        return params.topMargin > mMinHeaderViewHeight;
    }

    /**
     * 隐藏刷新动画
     *
     * @param params LayoutParams
     */
    private void hideHeadView(LayoutParams params) {
        //设置属性动画
        ValueAnimator animator = ValueAnimator.ofInt(params.topMargin, mMinHeaderViewHeight);
        animator.addUpdateListener(animation -> {
            params.topMargin = (int) animation.getAnimatedValue();
            mHeaderView.setLayoutParams(params);
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mCurrentRefreshState = RefreshState.IDLE;
                handRefreshState(mCurrentRefreshState);
            }
        });
        animator.setDuration(500);
        animator.start();
    }

    private LayoutParams getHeadViewLayoutParams() {
        return (LayoutParams) mHeaderView.getLayoutParams();
    }

    /**
     * 处理刷新的状态
     *
     * @param currentRefreshState RefreshState
     */
    private void handRefreshState(RefreshState currentRefreshState) {
        switch (currentRefreshState) {
            case IDLE:
                mRefreshManager.idleRefresh();
                break;
            case DOWN_REFRESH:
                mRefreshManager.downRefresh();
                break;
            case RELEASE_REFRESH:
                mRefreshManager.releaseRefresh();
                break;
            case REFRESHING:
                mRefreshManager.refreshing();
                break;
            case REFRESH_OVEW:
                break;
            default:
                break;
        }
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }


    private RefreshState mCurrentRefreshState = RefreshState.IDLE;

    /**
     * 定义下拉刷新的状态
     *
     * @author zhongyj
     * @date 2019/5/12
     */
    private enum RefreshState {
        /**
         * 静止
         */
        IDLE,
        /**
         * 下拉刷新
         */
        DOWN_REFRESH,
        /**
         * 释放刷新
         */
        RELEASE_REFRESH,
        /**
         * 正在刷新
         */
        REFRESHING,
        /**
         * 刷新完成
         */
        REFRESH_OVEW
    }
}





















