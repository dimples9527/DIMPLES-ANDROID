package com.dimples.http.result;

/**
 * @author zhongyj
 * @date 2019/4/16 12:25
 */
public interface IResultCallBack<T> {

    /**
     * 成功回调
     *
     * @param t T
     */
    void onSuccess(IResult<T> t);

    /**
     * 失败回调
     *
     * @param t T
     */
    void onFailed(IResult t);
}
