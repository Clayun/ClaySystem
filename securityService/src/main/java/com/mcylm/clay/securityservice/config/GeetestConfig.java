package com.mcylm.clay.securityservice.config;

/**
 * Created by lenovo on 2017/8/8.
 * GeetestWeb配置
 */
public class GeetestConfig {

    // 填入自己的captcha_id和private_key
    private static final String GEETTEST_ID = "002bc30ff1eef93e912f45814945e752";
    private static final String GEETEST_KEY = "4193a0e3247b82a26f563d595c447b1a";
    private static final boolean NEWFAILBACK = true;

    public static String getGeettestId() {
        return GEETTEST_ID;
    }

    public static String getGeetestKey() {
        return GEETEST_KEY;
    }

    public static boolean isNEWFAILBACK() {
        return NEWFAILBACK;
    }
}
