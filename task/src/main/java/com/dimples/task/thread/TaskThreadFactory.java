package com.dimples.task.thread;


import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
  *
  * @author zhongyj
  * @date 2019/4/15 23:36
  */
public class TaskThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(@NonNull Runnable r) {
        return new Thread(r, "task_thread_pool");
    }
}



















