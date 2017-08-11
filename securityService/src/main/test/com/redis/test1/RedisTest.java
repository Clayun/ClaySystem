package com.redis.test1;

import com.mcylm.clay.securityservice.util.Base64Utils;
import com.mcylm.clay.securityservice.util.RedisUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by lenovo on 2017/8/10.
 */
public class RedisTest {
    @Test
    public void string() throws IOException {
       /* String ss = RedisUtils.getValByKey("DDFCD28E43701D361D91B197C6CFE9D6");
        System.out.println(ss);*/
       String ss = "dddddddddddd";
        String string = Base64Utils.encodeBase64String(ss);
        System.out.println(string);


        String string1 = Base64Utils.decodeBase64String(string);
        System.out.println(string1);
    }


}
