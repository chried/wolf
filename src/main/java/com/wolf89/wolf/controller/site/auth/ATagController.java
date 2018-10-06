package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.ATagEntity;
import com.wolf89.wolf.service.article.ATagEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 标签控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/auth/tag")
public class ATagController extends AbstractEntityController<ATagEntity> {

    @Autowired
    private ATagEntityService aTagEntityService;

    @Override
    public AbstractEntityService getService() {
        return aTagEntityService;
    }
}
