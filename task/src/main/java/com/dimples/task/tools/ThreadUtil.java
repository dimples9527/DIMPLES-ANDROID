package com.dimples.task.tools;


import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {

    /**
     * 主线程的Handler
     */
    private final static Handler MAIN = new Handler(Looper.getMainLooper());

    public static void postMainThread(Runnable runnable) {
        MAIN.post(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
