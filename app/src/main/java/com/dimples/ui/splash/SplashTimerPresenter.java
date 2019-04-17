package com.dimples.ui.splash;

import android.content.Context;

import com.dimples.ui.main.MainActivity;
import com.dimples.mvp.base.BaseMvpPresenter;
import com.dimples.widget.CustomCountDownTimer;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 14:42
  */
public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private static CustomCountDownTimer timer;

    public SplashTimerPresenter(ISplashActivityContract.IView view) {
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
                getView().pageSwitch(mContext, MainActivity.class);
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

    /**
     * 防止 空指针异常
     *
     * @return ISplashActivityContract.IView
     */
    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.EMPTY_VIEW;
    }

}
