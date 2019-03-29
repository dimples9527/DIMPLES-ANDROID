package com.dimples.http;

import com.dimples.http.request.IRequest;

import java.util.Map;

/**
 * @author zhongyj
 * @date 2019/3/27 17:32
 */
public class HttpServer {

    protected Object execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
