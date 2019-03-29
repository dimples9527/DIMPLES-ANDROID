package com.dimples.http.okhttp;

import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author zhongyj
 * @date 2019/3/27 22:36
 */
public class OkHttpCall implements ICall {

    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
