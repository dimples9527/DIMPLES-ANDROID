package com.dimples.http.request;

import com.dimples.http.request.host.IHost;

import java.util.Map;

/**
 * @author zhongyj
 * @date 2019/3/27 17:35
 */
public interface IRequest {

    /**
     * 获取请求方式
     *
     * @return int
     */
    int getRequestMethod();

    /**
     * 设置参数
     *
     * @param params Map集合的参数
     */
    void setParams(Map<String, Object> params);

    /**
     * 获取参数
     *
     * @return Map<String, Object>
     */
    Map<String, Object> getParams();

    /**
     * 获取Host(host + path)
     *
     * @return IHost
     */
    IHost getHost();

    /**
     * 获取相对路径
     *
     * @return String
     */
    String getPath();

}
