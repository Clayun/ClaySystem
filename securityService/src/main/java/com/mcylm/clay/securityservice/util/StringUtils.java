package com.mcylm.clay.securityservice.util;

import java.util.UUID;

/**
 * Created by lenovo on 2017/8/9.
 */
public class StringUtils {

    //获取 UUid
    public static String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return removeHorizontalLine(uuid);
    }

    /**
     * 去除 uuid 中的 -
     * @param uuid
     * @return
     */
    public static String removeHorizontalLine(String uuid){
        return uuid.replaceAll("-", "");
    }
}
