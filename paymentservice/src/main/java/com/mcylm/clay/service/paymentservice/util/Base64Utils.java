package com.mcylm.clay.service.paymentservice.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2017/8/11.
 */
public class Base64Utils  {

    /**
     * 用base64算法进行加密
     * @param str 需要加密的字符串
     * @return base64加密后的结果
     */
    public static String encodeBase64String(String str) {
        BASE64Encoder encoder =  new BASE64Encoder();
        return encoder.encode(str.getBytes());
    }

    /**
     * 用base64算法进行解密
     * @param str 需要解密的字符串
     * @return base64解密后的结果
     * @throws IOException
     */
    public static String decodeBase64String(String str) {
        try {
            BASE64Decoder encoder =  new BASE64Decoder();
            return new String(encoder.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String encode(String str, String method) {
        MessageDigest md = null;
        String dstr = null;
        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return dstr;
    }


}

