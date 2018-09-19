package com.wolf89.wolf.controller;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定义首页控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/index")
public class IndexController {
    
    @Autowired
    private LoginService loginService;

    /**
     * 用户登录.
     *
     * @param form
     * @param result
     * @return
     */
    @PostMapping(value = "loginByName")
    public ApiOutput<String> loginByName(@RequestBody @Validated LoginForm form, BindingResult result) {

        return this.loginService.loginByName(form);

    }
}
