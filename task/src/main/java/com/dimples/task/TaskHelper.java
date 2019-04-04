package com.dimples.task;

/**
 * @author zhongyj
 * @date 2019/4/2 21:55
 */
public class TaskHelper {

    public static void submitTask(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        AsyncTaskInstance instance = AsyncTaskInstance.getInstance(iTaskBackground, iTaskCallback);
        //构建线程池管理器
        TaskScheduler.getInstance().submit(instance);
    }
}
