package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AColumnEntity;
import com.wolf89.wolf.service.article.AColumnEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 栏目控制器.
 *
 * @author chried
 */
@RequestMapping(value = "rest/auth/column")
@RestController
public class AColumnController extends AbstractEntityController<AColumnEntity> {

    @Autowired
    private AColumnEntityService aColumnEntityService;

    @Override
    public AbstractEntityService getService() {
        return aColumnEntityService;
    }

    /**
     * 提交前操作.
     *
     * @param aColumnEntity 对象.
     */
    @Override
    protected void beforeSave_(AColumnEntity aColumnEntity) {

        if (aColumnEntity.getAuthor() == null) {
            aColumnEntity.setAuthor(this.getCurrentToken_().getUser());
        }
    }
}
