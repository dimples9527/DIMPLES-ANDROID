package com.dimples.http.okhttp;

import com.dimples.http.response.IResponse;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Response;

/**
  *
  * @author zhongyj
  * @date 2019/4/15 20:53
  */
public class OkHttpResponse implements IResponse {


    private final Response response;

    public OkHttpResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getBodyString() {
        try {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

















