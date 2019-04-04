package com.dimples.task;

import com.dimples.task.tools.ThreadUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zhongyj
 * @date 2019/4/2 22:06
 */
public class AsyncTaskInstance extends FutureTask {

    private ITaskBackground iTaskBackground;
    private ITaskCallback iTaskCallback;

    private AsyncTaskInstance(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        super(new Callable() {
            @Override
            public Object call() {
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
            Object object = get();
            if (object != null) {
                //确保成功的回调方法一定运行在主线程中
                ThreadUtil.postMainThread(new Runnable() {
                    @Override
                    public void run() {
                        iTaskCallback.onSuccess(object);
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





















