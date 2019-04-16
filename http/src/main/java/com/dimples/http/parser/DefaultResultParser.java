package com.dimples.http.parser;

import android.util.Log;

import com.dimples.http.request.IRequest;
import com.dimples.http.response.IResponse;
import com.dimples.http.result.IResult;
import com.dimples.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author zhongyj
 * @date 2019/4/15 21:20
 */
public class DefaultResultParser implements IParser {

    private static final String D_TAG = "D-DefaultResultParser";
    private static DefaultResultParser instance;
    private final Gson mGson;

    private DefaultResultParser() {
        mGson = new Gson();
    }

    public static IParser getInstance() {
        if (instance == null) {
            instance = new DefaultResultParser();
        }
        return instance;
    }

    @Override
    public IResult parserResponse(IRequest request, IResponse response) {
        Type type = request.getType();
        String bodyString = response.getBodyString();
        Log.i(D_TAG, "parserResponse: " + bodyString);
        Object object = mGson.fromJson(bodyString, type);
        return Result.success(object);
    }
}


























