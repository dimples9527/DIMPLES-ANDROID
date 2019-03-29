package com.dimples.http.request.call;

/**
 * @author zhongyj
 * @date 2019/3/27 21:40
 */
public interface ICall {

    /**
     * 执行同步网络请求
     *
     * @return Object
     */
    Object execute();

}
