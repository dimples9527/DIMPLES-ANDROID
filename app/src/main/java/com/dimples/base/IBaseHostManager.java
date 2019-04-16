package com.dimples.base;

import com.dimples.http.request.host.IHost;

/**
 * @author zhongyj
 * @date 2019/3/27 20:55
 */
public interface IBaseHostManager {

    String HOST_IP = "http://47.106.102.235:8088/dimples";

    IHost HOST = new IHost() {
        @Override
        public String getHost() {
            return HOST_IP;
        }

        @Override
        public String getDefaultPath() {
            return "/";
        }
    };

    void setHostIp(IHost hostIp);

}
