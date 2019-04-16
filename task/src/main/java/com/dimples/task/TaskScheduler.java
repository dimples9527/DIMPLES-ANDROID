package com.dimples.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.dimples.task.thread.PriorityThreadPoolExecutor;
import com.dimples.task.thread.TaskThreadFactory;
import com.dimples.task.tools.ThreadUtil;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author zhongyj
 * @date 2019/4/2 22:34
 */
public class TaskScheduler {

    private static TaskScheduler instance;
    private final Handler handler;
    private final PriorityThreadPoolExecutor executor;
    private static final int CORE_POOL_SIZE = ThreadUtil.CPU_NUM + 1;
    private static final int MAXIMUM_POOL_SIZE = CORE_POOL_SIZE * 3;
    private static final long KEEP_ALIVE_TIME = 1;

    private TaskScheduler() {
        //用于消息调度的线程
        HandlerThread handlerThread = new HandlerThread("task-thread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            //HandlerThread handleMessage运行在子线程
            @Override
            public boolean handleMessage(Message msg) {
                switch (msg.what) {
                    case ITaskSchedulerType.SUBMIT_TASK:
                        doSubmitTask((AsyncTaskInstance) msg.obj);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        //创建一个线程池
        BlockingQueue<Runnable> poolQueue = new LinkedBlockingDeque<>();
        this.executor = new PriorityThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MINUTES,
                poolQueue,
                new TaskThreadFactory());
    }

    private void doSubmitTask(AsyncTaskInstance taskInstance) {
        executor.submit(taskInstance);
    }

    public static TaskScheduler getInstance() {
        if (instance == null) {
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance) {
        handler.sendMessage(handler.obtainMessage(ITaskSchedulerType.SUBMIT_TASK, instance));
    }

    interface ITaskSchedulerType {
        int SUBMIT_TASK = 0;
    }

}












