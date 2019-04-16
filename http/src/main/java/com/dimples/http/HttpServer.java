package com.dimples.http;

import com.dimples.http.request.IRequest;
import com.dimples.http.result.IResult;

import java.util.Map;

/**
 * @author zhongyj
 * @date 2019/3/27 17:32
 */
public class HttpServer {

    protected <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }
}
