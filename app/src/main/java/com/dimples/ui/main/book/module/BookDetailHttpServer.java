package com.dimples.ui.main.book.module;

import com.dimples.http.HttpServer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求网络数据
 *
 * @author zhongyj
 * @date 2019/3/27 17:26
 */
public class BookDetailHttpServer extends HttpServer {

    public Object getData(String doctorCode, String status) {
        Map<String, Object> params = new HashMap<>(2);
        params.put("doctorCode", doctorCode);
        params.put("status", status);
        return super.execute(BookDetailRequest.REQUEST, params);
    }

}
