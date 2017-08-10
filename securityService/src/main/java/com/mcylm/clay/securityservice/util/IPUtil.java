package com.mcylm.clay.securityservice.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Ip工具类
 * Created by lenovo on 2017/8/9.
 */
public class IPUtil {


    //获取 host ip
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            return ip;
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            return ip;
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            return ip;
        }
        return ip;
    }
}
