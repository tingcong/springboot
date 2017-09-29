package com.springboot.common.config;

import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Repository;

/**
 * Spring Data Rest 配置(在RepositoryRestMvcAutoConfiguration中已经配好了)
 * 可以通过继承此类或者直接在自己的配置类上@Import此配置类
 * Created by htc on 2017/9/29.
 */

@Configuration
public class CustomRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration{
    @Override
    public RepositoryRestConfiguration config(){
        return super.config();
    }
    //其他可以重写以config开头的方法
}
