package com.dimples.task;

/**
 * @author zhongyj
 * @date 2019/3/28 11:33
 */
interface ITaskBackground<T> {

    /**
     * 执行网络请求线程
     *
     * @return Object
     */
    T onBackground();
}
