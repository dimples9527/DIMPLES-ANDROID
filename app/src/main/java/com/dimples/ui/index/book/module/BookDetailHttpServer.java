package com.dimples.ui.index.book.module;

import com.dimples.http.HttpServer;
import com.dimples.http.result.IResult;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求网络数据
 *
 * @author zhongyj
 * @date 2019/3/27 17:26
 */
public class BookDetailHttpServer<T> extends HttpServer {

    public IResult<T> getData(String doctorCode, String status) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("doctorCode", doctorCode);
        params.put("status", status);
        return super.execute(BookDetailRequest.REQUEST, params);
    }

}
