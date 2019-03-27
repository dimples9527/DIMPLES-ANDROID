package com.dimples.http;

import java.util.Map;
import java.util.Objects;

/**
 * @author zhongyj
 * @date 2019/3/27 17:32
 */
public class BaseHttpFactory {

    protected Object execute(IRequest request, Map<String, Objects> params) {
        return HttpHelper.execute(request, params);
    }
}
