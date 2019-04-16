package com.dimples.http.request.call;

import com.dimples.http.request.IRequest;
import com.dimples.http.response.IResponse;

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
    IResponse execute();

    /**
     * 获取Request
     *
     * @return IRequest
     */
    IRequest getRequest();

}
