package com.dimples.task;

import com.dimples.task.tools.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhongyj
 * @date 2019/4/2 22:06
 */
public class AsyncTaskInstance<T> extends FutureTask<T> {

    private ITaskBackground<T> iTaskBackground;
    private ITaskCallback<T> iTaskCallback;

    private AsyncTaskInstance(ITaskBackground<T> iTaskBackground, ITaskCallback<T> iTaskCallback) {
        super(new Callable<T>() {
            @Override
            public T call() {
                return iTaskBackground.onBackground();
            }
        });
        this.iTaskBackground = iTaskBackground;
        this.iTaskCallback = iTaskCallback;

    }

    @Override
    protected void done() {
        if (iTaskBackground != null) {
            onComplete();
        }
    }

    /**
     * 获取FutureTask执行过程中的异常
     *
     * @param t Throwable
     */
    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        if (iTaskCallback != null) {
            ThreadUtil.postMainThread(new Runnable() {
                @Override
                public void run() {
                    iTaskCallback.onException(t);
                }
            });
        }
    }

    private void onComplete() {
        try {
            T object = get();
            if (object != null) {
                //确保成功的回调方法一定运行在主线程中
                ThreadUtil.postMainThread(new Runnable() {
                    @Override
                    public void run() {
                        iTaskCallback.onComplete(object);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AsyncTaskInstance getInstance(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        return new AsyncTaskInstance(iTaskBackground, iTaskCallback);
    }
}





















