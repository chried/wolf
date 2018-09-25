package com.wolf89.wolf.controller.site;

import com.wolf89.wolf.core.controller.AbstractController;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.user.LoginForm;
import com.wolf89.wolf.dto.user.LoginResult;
import com.wolf89.wolf.model.entity.system.SLoginInfoEntity;
import com.wolf89.wolf.service.system.SLoginInfoEntityService;
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
public class IndexController extends AbstractController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SLoginInfoEntityService sLoginInfoEntityService;

    /**
     * 用户登录.
     *
     * @param form
     * @param result
     * @return
     */
    @PostMapping(value = "loginByName")
    public ApiOutput<LoginResult> loginByName(@RequestBody @Validated LoginForm form, BindingResult result) {

        // 用户登录.
        LoginResult loginResult = this.loginService.loginByName(form).getData();

        // 记录登录信息.
        SLoginInfoEntity sLoginInfoEntity = new SLoginInfoEntity();

        sLoginInfoEntity.setIp(request.getRemoteAddr());
        sLoginInfoEntity.setUserId(loginResult.getUser().getId());
        sLoginInfoEntity.setType(form.getType());

        this.sLoginInfoEntityService.save(sLoginInfoEntity);

        return ApiOutput.of(loginResult);
    }
}
