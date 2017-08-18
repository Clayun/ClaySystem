package com.mcylm.clay.service.openstackService.utils;

import java.util.UUID;

/**
 * Created by Mikesam on 2017/8/11.
 */
public class Utils {

    public static String createUuid() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return temp;
    }


}
