package com.dimples.task;

/**
 * @author zhongyj
 * @date 2019/3/28 11:34
 */
interface ITaskCallback<T> {

    /**
     * 数据请求成功回调
     *
     * @param o Object
     */
    void onComplete(T o);

    /**
     * 数据请求失败回调
     *
     * @param throwable Throwable
     */
    void onException(Throwable throwable);

}












