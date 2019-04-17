package com.dimples.http.okhttp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.dimples.http.AbstractHttpScheduler;
import com.dimples.http.annotation.RequestMethod;
import com.dimples.http.https.Https;
import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;

import java.util.Map;
import java.util.Objects;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 生成网络请求
 *
 * @author zhongyj
 * @date 2019/3/27 21:46
 */
public class OkHttpScheduler extends AbstractHttpScheduler {

    private OkHttpClient client;

    /**
     * 生成对应的网络请求
     *
     * @param request IRequest
     * @return ICall
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();
        switch (requestMethod) {
            //生成get请求
            case RequestMethod.Get:
                //拼接get请求的URL (host + path)
                String url = request.getHost().getHost() + request.getPath();
                HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
                if (params != null && params.size() > 0) {
                    for (Map.Entry<String, Object> next : params.entrySet()) {
                        // REMAKE: 待重构 2019/1/6  这里涉及对象如何转成String 字符串
                        urlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;
            //生成post请求
            case RequestMethod.Post:
                // TODO: 2019/3/27 post请求
                break;
            default:
                break;
        }
        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        //封装到自定义的Call中
        return new OkHttpCall(request, call);
    }

    @SuppressLint("BadHostnameVerifier")
    private OkHttpClient getClient() {
        if (client == null) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.sslSocketFactory(Https.getSSLSocketFactory());
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            client = builder.build();
        }
        return client;
    }

}










