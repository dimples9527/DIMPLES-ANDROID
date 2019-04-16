package com.dimples.base;

import com.dimples.http.annotation.RequestMethod;
import com.dimples.http.parser.DefaultResultParser;
import com.dimples.http.request.HttpRequest;
import com.dimples.http.request.IRequest;

import java.lang.reflect.Type;

/**
 * 基础的网络请求类
 *
 * @author zhongyj
 * @date 2019/3/27 18:17
 */
public class BaseHttpRequest extends HttpRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod, Type type) {
        BaseHttpRequest request = new BaseHttpRequest();
        request.host = IBaseHostManager.HOST;
        request.requestMethod = requestMethod;
        request.path = path;
        request.type = type;
        request.resultParser = DefaultResultParser.getInstance();
        return request;
    }

}














