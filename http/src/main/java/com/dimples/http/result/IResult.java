package com.dimples.http.result;

/**
 * 所有IResponse解析后的结果
 *
 * @author zhongyj
 * @date 2019/4/15 20:33
 */
public interface IResult<T> {

    /**
     * 是否请求成功
     *
     * @return boolean
     */
    boolean isSuccess();

    /**
     * 获取返回码
     *
     * @return int
     */
    int getCode();

    /**
     * 获取数据
     *
     * @return T
     */
    T getData();

}
