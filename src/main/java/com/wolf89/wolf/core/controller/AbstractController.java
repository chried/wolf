package com.wolf89.wolf.core.controller;


import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 父级控制器.
 *
 * @author chried
 */
public abstract class AbstractController {

    /**
     * 请求注入.
     */
    @Autowired
    protected HttpServletRequest request;

    /**
     * 响应注入.
     */
    @Autowired
    protected HttpServletResponse response;

}
