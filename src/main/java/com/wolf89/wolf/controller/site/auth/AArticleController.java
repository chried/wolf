package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.controller.AbstractEntityController;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.service.article.AArticleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章相关控制器.
 *
 * @author gaoweibing
 */
@RestController
@RequestMapping(value = "rest/auth/article")
public class AArticleController extends AbstractEntityController<AArticleEntity> {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleController.class);

    @Autowired
    private AArticleEntityService aArticleEntityService;

    /**
     * 提交前操作.
     *
     * @param aArticleEntity 对象.
     */
    @Override
    protected void beforeSave_(AArticleEntity aArticleEntity) {

        if (aArticleEntity.getAuthor() == null) {
            aArticleEntity.setAuthor(this.getCurrentToken_().getUser());
        }
    }

    @Override
    public AbstractEntityService getService() {
        return aArticleEntityService;
    }

}
