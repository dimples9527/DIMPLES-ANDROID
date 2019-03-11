package com.dimples.widget;

import android.os.Handler;

/**
 * 1、实时去回调，此时是什么时间，倒计时几秒
 * 观察者设计模式
 * 2、支持动态传入总时间
 * 3、每过一秒，总时间－1
 * 4、总时间为0时，要回调完成的状态
 *
 * @author zhongyj
 * @date 2019/3/11 17:00
 */
public class CustomCountDownTimer implements Runnable {

    private int time;
    private int countDownTime;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;

    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler) {
        handler = new Handler();
        this.time = time;
        this.countDownTime = time;
        this.countDownHandler = countDownHandler;
    }

    /**
     * 倒计时实现的具体代码
     *
     * @author zhongyj
     * @date 2019/3/11 17:22
     */
    @Override
    public void run() {
        if (isRun) {
            if (countDownHandler != null) {
                countDownHandler.onTicker(countDownTime);
            }
            if (countDownTime == 0) {
                if (countDownHandler != null) {
                    countDownHandler.onFinish();
                }
            } else {
                countDownTime = time--;
                handler.postDelayed(this, 1000);
            }
        }
    }

    /**
     * 开始倒计时
     *
     * @author zhongyj
     * @date 2019/3/11 17:19
     */
    public void start() {
        isRun = true;
        handler.post(this);
    }

    /**
     * 跳出循环，终止
     *
     * @author zhongyj
     * @date 2019/3/11 17:21
     */
    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    /**
     * 观察者回调方法 (IOC 数据回调)
     *
     * @author zhongyj
     * @date 2019/3/11 17:21
     */
    public interface ICountDownHandler {
        /**
         * 倒计时回调
         *
         * @param time int
         */
        void onTicker(int time);

        /**
         * 完成时回调
         */
        void onFinish();
    }

}














