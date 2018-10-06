package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AZArticleEntity;
import com.wolf89.wolf.service.article.AZArticleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 转载文章控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/auth/z/article")
public class AZArticleController extends AbstractEntityController<AZArticleEntity> {

    @Autowired
    private AZArticleEntityService azArticleEntityService;

    /**
     * 提交前操作.
     *
     * @param azArticleEntity 对象.
     */
    @Override
    protected void beforeSave_(AZArticleEntity azArticleEntity) {

        if (azArticleEntity.getAuthor() == null) {
            azArticleEntity.setAuthor(this.getCurrentToken_().getUser());
        }
    }

    @Override
    public AbstractEntityService getService() {
        return azArticleEntityService;
    }
}
