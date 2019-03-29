package com.dimples.http;

import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;

/**
  *
  * @author zhongyj
  * @date 2019/3/27 21:45
  */
public abstract class HttpScheduler {

    public abstract ICall newCall(IRequest request);

    public Object execute(ICall call) {
        return call.execute();
    }
}
