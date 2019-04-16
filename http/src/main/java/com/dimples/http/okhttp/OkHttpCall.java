package com.dimples.http.okhttp;

import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;
import com.dimples.http.response.IResponse;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * @author zhongyj
 * @date 2019/3/27 22:36
 */
public class OkHttpCall implements ICall {

    private IRequest request;
    private Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.request = request;
        this.call = call;
    }

    @Override
    public IResponse execute() {
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //使用静态代理的方式，将OkHttp的Response转换成自定义的IResponse
        return new OkHttpResponse(response);
    }

    @Override
    public IRequest getRequest() {
        return request;
    }
}












