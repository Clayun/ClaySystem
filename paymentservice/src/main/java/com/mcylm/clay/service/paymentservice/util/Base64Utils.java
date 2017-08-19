package com.mcylm.clay.service.paymentservice.util;


import com.google.gson.Gson;
import com.mcylm.clay.service.paymentservice.model.EcsServer;
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


  /*  public static void main(String[] args) {
//        String ss = "eyJpZCI6MCwidXVpZCI6IjQ0YjFmYjU2NmU1YzRlNDhiNzE3MzE1NDI4ZTM1ZDg3Iiwic2VyX3V1aWQiOiJjNTZkMGI3NjdmNGU0NjBjYTk3M2UyZjFiNDBlYWZhNCIsInNlcl9uYW1lIjoiNDg2YzQ5MmU3YmU0NDNmYzg5ZmYwNWJhOGRhZWYxYjQiLCJjcHUiOiIxNiIsIm1lbW9yeSI6IjgiLCJvc19kaXNrIjoiMTAwIiwiZXhwYW5kX2Rpc2siOiI1MCIsInRhcGUiOiIxMCIsImlwcyI6IjEiLCJpbWFnZSI6IndpbmRvd3M3IiwicGFzc3dvcmQiOiJhZGFzZGFzZGFkYXNkIiwiZGF5cyI6IjAiLCJwcmljZVBlck1vbnRoIjoiMTI5MC4wIiwic3RhdGUiOiIxIiwiY3JlYXRlVGltZSI6IkF1ZyAxNiwgMjAxNyAxMDoxMzoyNCBBTSJ9";
        String sss="ZXlKcFpDSTZNQ3dpZFhWcFpDSTZJalEwWWpGbVlqVTJObVUxWXpSbE5EaGlOekUzTXpFMU5ESTRaVE0xWkRnM0lpd2ljMlZ5WDNWMWFXUWlPaUpqTlRaa01HSTNOamRtTkdVME5qQmpZVGszTTJVeVpqRmlOREJsWVdaaE5DSXNJbk5sY2w5dVlXMWxJam9pTkRnMll6UTVNbVUzWW1VME5ETm1Zemc1Wm1Zd05XSmhPR1JoWldZeFlqUWlMQ0pqY0hVaU9pSXhOaUlzSW0xbGJXOXllU0k2SWpnaUxDSnZjMTlrYVhOcklqb2lNVEF3SWl3aVpYaHdZVzVrWDJScGMyc2lPaUkxTUNJc0luUmhjR1VpT2lJeE1DSXNJbWx3Y3lJNklqRWlMQ0pwYldGblpTSTZJbmRwYm1SdmQzTTNJaXdpY0dGemMzZHZjbVFpT2lKaFpHRnpaR0Z6WkdGa1lYTmtJaXdpWkdGNWN5STZJakFpTENKd2NtbGpaVkJsY2sxdmJuUm9Jam9pTVRJNU1DNHdJaXdpYzNSaGRHVWlPaUl4SWl3aVkzSmxZWFJsVkdsdFpTSTZJa0YxWnlBeE5pd2dNakF4TnlBeE1Eb3hNem95TkNCQlRTSjk=";
        String s = decodeBase64String(sss);
        Gson gson = new Gson();
        EcsServer ecsServer = gson.fromJson(s, EcsServer.class);
        System.out.println(ecsServer);
        System.out.println(s);
    }*/


}

