package com.wolf89.wolf.controller;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登陆控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(name = "rest/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 用户登录.
     *
     * @param form
     * @param result
     * @return
     */
    @RequestMapping(value = "loginByName")
    public ApiOutput<String> loginByName(@RequestBody @Validated LoginForm form, BindingResult result) {

        return this.loginService.loginByName(form);

    }
}
