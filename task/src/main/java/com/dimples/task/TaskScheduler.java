package com.dimples.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/**
 * @author zhongyj
 * @date 2019/4/2 22:34
 */
public class TaskScheduler {

    private static TaskScheduler instance;
    private final Handler handler;

    private TaskScheduler() {
        //用于消息调度的线程
        HandlerThread handlerThread = new HandlerThread("task-thread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            //HandlerThread handleMessage运行在子线程
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });
    }

    public static TaskScheduler getInstance() {
        if (instance == null) {
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance) {

    }
}












