package com.dimples.http;

import com.dimples.http.okhttp.OkHttpScheduler;
import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;

import java.util.Map;

/**
 * @author zhongyj
 * @date 2019/3/27 17:38
 */
public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    public static HttpScheduler getHttpScheduler() {
        if (httpScheduler == null) {
            synchronized (HttpHelper.class) {
                if (httpScheduler == null) {
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }

    protected static Object execute(IRequest request, Map<String, Object> params) {
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(call);
    }

}
