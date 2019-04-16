package com.dimples.http;

import com.dimples.http.parser.IParser;
import com.dimples.http.request.IRequest;
import com.dimples.http.request.call.ICall;
import com.dimples.http.response.IResponse;
import com.dimples.http.result.IResult;

/**
 * @author zhongyj
 * @date 2019/3/27 21:45
 */
public abstract class AbstractHttpScheduler {

    /**
     * 回调
     *
     * @param request IRequest
     * @return ICall
     */
    public abstract ICall newCall(IRequest request);

    public IResult execute(ICall call) {
        //IResponse和IResult之间的转换
        IResponse response = call.execute();
        IRequest request = call.getRequest();
        IParser parser = request.getParser();
        return parser.parserResponse(request, response);
    }
}



















