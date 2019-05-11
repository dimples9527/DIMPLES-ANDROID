package com.dimples.ui.index.book.bean;


import java.util.List;

/**
 * 服务通信的交互类
 *
 * @author zhongyj
 * @date 2018/10/30 21:31
 */
public class TreatPatientResultBean {

    /**
     * 成功状态码
     */
    public static final int SUCCESS = 200;
    /**
     * 失败状态码
     */
    public static final int FAILURE = 504;

    public static final String SUCCESS_MESSAGE = "操作成功";

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 操作消息
     */
    private String message;
    /**
     * 数据
     */
    private List<TreatPatientBean> data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TreatPatientBean> getData() {
        return data;
    }

    public void setData(List<TreatPatientBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreatPatientResultBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}














