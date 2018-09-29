package com.wolf89.wolf.controller.admin.auth;

import com.wolf89.wolf.core.controller.AbstractClassifyEntityController;
import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractClassifyEntityService;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.system.SClassifyEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分类管理.
 *
 * @author gaoweibing
 */
@RequestMapping(value = "admin/classify")
@RestController
public class SClassifyController extends AbstractClassifyEntityController<SClassifyEntity> {

    @Override
    public AbstractClassifyEntityService<SClassifyEntity> getService() {
        return null;
    }
}
