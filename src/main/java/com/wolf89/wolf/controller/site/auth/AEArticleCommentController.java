package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AEArticleCommentEntity;
import com.wolf89.wolf.service.article.AEArticleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 英文评论控制器.
 *
 * @author chried
 */
@RestController
@RequestMapping(value = "rest/auth/e/article/comment")
public class AEArticleCommentController extends AbstractEntityController<AEArticleCommentEntity> {

    @Autowired
    private AEArticleEntityService aeArticleEntityService;

    @Override
    public AbstractEntityService getService() {
        return aeArticleEntityService;
    }
}
