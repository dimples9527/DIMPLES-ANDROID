package com.dimples.base;

import com.dimples.http.IRequest;
import com.dimples.http.annotation.RequestMethod;

/**
 * 基础的网络请求类
 *
 * @author zhongyj
 * @date 2019/3/27 18:17
 */
public class BaseHttpRequest implements IRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod) {
        BaseHttpRequest request = new BaseHttpRequest();
        return null;
    }
}
