package com.dimples.task;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 11:34
  */
interface ITaskCallback {

    /**
     * 数据请求成功回调
     * @param o Object
     */
    void onSuccess(Object o);

    void onException(Throwable throwable);

}
