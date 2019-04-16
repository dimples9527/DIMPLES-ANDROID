package com.dimples.base;

import com.dimples.http.result.IResult;
import com.dimples.http.result.IResultCallBack;
import com.dimples.http.result.Result;
import com.dimples.task.AbstractTask;

/**
 * @author zhongyj
 * @date 2019/4/15 23:45
 */
public abstract class BaseTask<T> extends AbstractTask<IResult<T>> implements IResultCallBack<T> {

    @Override
    public void onComplete(IResult<T> iResult) {
        if (iResult != null) {
            if (iResult.isSuccess()) {
                onSuccess(iResult);
            } else {
                //1次失败
                onFailed(Result.failed(Result.CODE_505));
            }
        } else {
            //2次失败
            onFailed(Result.failed(Result.CODE_404));
        }

    }

    @Override
    public void onFailed(IResult t) {
        switch (t.getCode()) {
            //可以做成统一错误码处理
            case Result.CODE_404:
                break;
            case Result.CODE_505:
                break;
            case Result.CODE_504:
                break;
            default:
                break;
        }
    }

    @Override
    public void onException(Throwable throwable) {
        //3次失败
        onFailed(Result.failed(Result.CODE_504));
    }
}














