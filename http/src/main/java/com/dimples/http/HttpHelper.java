package com.dimples.http;

import com.dimples.http.okhttp.OkHttpScheduler;
import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;
import com.dimples.http.result.IResult;

import java.util.Map;

/**
 * @author zhongyj
 * @date 2019/3/27 17:38
 */
public class HttpHelper {

    private volatile static AbstractHttpScheduler abstractHttpScheduler;

    public static AbstractHttpScheduler getAbstractHttpScheduler() {
        if (abstractHttpScheduler == null) {
            synchronized (HttpHelper.class) {
                if (abstractHttpScheduler == null) {
                    abstractHttpScheduler = new OkHttpScheduler();
                }
            }
        }
        return abstractHttpScheduler;
    }

    protected static <T> IResult<T> execute(IRequest request, Map<String, Object> params) {
        request.setParams(params);
        ICall call = getAbstractHttpScheduler().newCall(request);
        return getAbstractHttpScheduler().execute(call);
    }

}
