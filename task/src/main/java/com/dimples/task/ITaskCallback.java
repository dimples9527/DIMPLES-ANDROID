package com.dimples.task;

/**
  *
  * @author zhongyj
  * @date 2019/3/28 11:34
  */
interface ITaskCallback {

    void onSuccess(Object o);

    void onException(Throwable throwable);

}
