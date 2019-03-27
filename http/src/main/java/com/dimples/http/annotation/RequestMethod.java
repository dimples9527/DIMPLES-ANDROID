package com.dimples.http.annotation;

import android.support.annotation.IntDef;

import static com.dimples.http.annotation.RequestMethod.Delete;
import static com.dimples.http.annotation.RequestMethod.Get;
import static com.dimples.http.annotation.RequestMethod.Post;
import static com.dimples.http.annotation.RequestMethod.Put;

/**
 * 网络请求方式
 *
 * @author zhongyj
 * @date 2019/3/27 17:56
 */
@IntDef({Get, Post, Put, Delete})
public @interface RequestMethod {

    int Get = 1;

    int Post = 2;

    int Put = 3;

    int Delete = 4;
}
