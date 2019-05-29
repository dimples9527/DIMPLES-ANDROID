package com.dimples.ui.splash;

import android.content.Context;

import com.dimples.base.BasePresenter;
import com.dimples.ui.index.IndexActivity;
import com.dimples.widget.CustomCountDownTimer;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 14:42
  */
public class SplashTimerPresenter extends BasePresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private static CustomCountDownTimer timer;

    SplashTimerPresenter(ISplashActivityContract.IView view) {
        super(view);
        mContext = (Context) view;
    }

    @Override
    public void initTimer() {
        timer = new CustomCountDownTimer(3, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer("跳过(" + time + ")");
            }

            @Override
            public void onFinish() {
                getView().pageSwitch(mContext, IndexActivity.class);
            }
        });
        timer.start();
    }

    private void cancel() {
        timer.cancel();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }


}
