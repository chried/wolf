package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.model.entity.article.AEArticleEntity;
import com.wolf89.wolf.service.article.AEArticleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 英文翻译文章控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/auth/e/article")
public class AEArticleController extends AbstractEntityController<AEArticleEntity> {

    @Autowired
    private AEArticleEntityService aeArticleEntityService;

    /**
     * 提交前操作.
     *
     * @param aeArticleEntity 对象.
     */
    @Override
    protected void beforeSave_(AEArticleEntity aeArticleEntity) {

        if (aeArticleEntity.getAuthor() == null) {
            aeArticleEntity.setAuthor(this.getCurrentToken_().getUser());
        }
    }

    @Override
    public AbstractEntityService getService() {
        return aeArticleEntityService;
    }
}
