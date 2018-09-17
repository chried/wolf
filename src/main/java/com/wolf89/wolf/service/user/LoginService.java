package com.wolf89.wolf.service.user;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractService;
import com.wolf89.wolf.dto.user.LoginForm;

/**
 * 登录 service.
 *
 * @author gaoweibing
 */
public interface LoginService extends AbstractService {

    /**
     * 用户登录.
     *
     * @param form 参数.
     * @return 登录信息.
     */
    ApiOutput<String> loginByName(LoginForm form);
}
