package com.dimples.http.parser;

import com.dimples.http.request.IRequest;
import com.dimples.http.response.IResponse;
import com.dimples.http.result.IResult;

/**
 * @author zhongyj
 * @date 2019/4/15 21:19
 */
public interface IParser {

    /**
     * 解析返回的数据
     * @param request IRequest
     * @param response IResponse
     * @return IResult
     */
    IResult parserResponse(IRequest request, IResponse response);
}
















