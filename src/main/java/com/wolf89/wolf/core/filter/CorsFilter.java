/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolf89.wolf.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器配置.
 *
 * @author tangfeifei
 */
public class CorsFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CorsFilter.class);

    /**
     * 过滤器配置.
     */
    private FilterConfig filterConfig;

    /**
     * 允许跨域范围.
     */
    private String allowOrigin = "*";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = ((HttpServletRequest) request);
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if ("*".equals(allowOrigin)) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        }

        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,PUT,PATCH,DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,sso-token,sso-ticket");

        /**
         * OPTIONS 方法比较少见，该方法用于请求服务器告知其支持哪些其他的功能和方法。 通过 OPTIONS
         * 方法，可以询问服务器具体支持哪些方法，或者服务器会使用什么样的方法来处理一些特殊资源。
         * 可以说这是一个探测性的方法，客户端通过该方法可以在不访问服务器上实际资源的情况下就知道处理该资源的最优方式。
         * OPTIONS 方法在跨域请求（CORS）中的应用 客户端发起的这个 OPTIONS
         * 可以说是一个“预请求”，用于探测后续真正需要发起的跨域 POST
         * 请求对于服务器来说是否是安全可接受的，因为跨域提交数据对于服务器来说可能存在很大的安全问题。
         */
        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            //服务器成功处理了请求，但没有返回任何内容。
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        LOG.info("初始化跨域过滤器.");

        this.filterConfig = config;

        allowOrigin = this.filterConfig.getInitParameter("allowOrigin");

        LOG.info("跨域设置[{}]", this.allowOrigin);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

        this.filterConfig = null;
    }

}
