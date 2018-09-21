/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.config;

import com.wolf89.wolf.core.filter.AuthorizeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * 权限配置.
 *
 * @author tangfeifei
 */
@Configuration
public class AuthConfig {

    private static final Logger LOG = LoggerFactory.getLogger(AuthConfig.class);

    @Bean
    public FilterRegistrationBean authorizeFilterRegistration() {

        LOG.info("注册权限过滤器!");

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(this.createAuthorizeFilter());
        registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registration.addUrlPatterns("/auth/*");
        registration.setName("Authorize Filter");

        registration.setOrder(200);

        return registration;
    }

    @Bean
    public AuthorizeFilter createAuthorizeFilter() {

        return new AuthorizeFilter();
    }

}
