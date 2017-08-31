package com.mcylm.clay.securityservice.Initializer;

import com.mcylm.clay.securityservice.config.HttpSessionConfig;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by Mikesam on 2017/8/31.
 */
public class HttpSessionRedisInitializer extends AbstractHttpSessionApplicationInitializer {
    public HttpSessionRedisInitializer() {
        super(HttpSessionConfig.class);
    }
}
