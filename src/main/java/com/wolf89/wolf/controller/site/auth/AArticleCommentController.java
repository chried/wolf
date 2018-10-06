package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AArticleCommentEntity;
import com.wolf89.wolf.service.article.AArticleCommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章评论.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/auth/comment")
public class AArticleCommentController extends AbstractEntityController<AArticleCommentEntity> {

    @Autowired
    private AArticleCommentEntityService aArticleCommentEntityService;

    /**
     * 提交前操作.
     *
     * @param aArticleCommentEntity 对象.
     */
    @Override
    protected void beforeSave_(AArticleCommentEntity aArticleCommentEntity) {

        aArticleCommentEntity.setUser_(this.getCurrentToken_().getUser());
    }

    @Override
    public AbstractEntityService getService() {
        return aArticleCommentEntityService;
    }
}
