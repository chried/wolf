package com.wolf89.wolf.core.filter;

import com.wolf89.wolf.core.parameter.Parameter;
import com.wolf89.wolf.service.system.STokenCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证过滤器.
 *
 * @author gaoweibing
 */
public class AuthorizeFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorizeFilter.class);

    @Autowired
    private STokenCacheService sTokenCacheService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("权限过滤器初始化");
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        HttpServletResponse response = (HttpServletResponse) resp;

        String token = request.getHeader(Parameter.W_TOKEN);

        // 验证token.
        if (sTokenCacheService.validateToken(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "您还没有登录，或登录凭证已过期!");
            return;
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        LOG.info("权限过滤器销毁");
    }
}
