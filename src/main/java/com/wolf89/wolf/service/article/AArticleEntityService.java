package com.wolf89.wolf.service.article;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractEntityService;
import com.wolf89.wolf.dto.article.ArticleForm;
import com.wolf89.wolf.model.entity.article.AArticleEntity;

/**
 * service.
 *
 * @author gaoweibing
 */
public interface AArticleEntityService extends AbstractEntityService<AArticleEntity> {

    /**
     * 提交.
     *
     * @param form 参数.
     * @return 成功信息.
     */
    ApiOutput<String> submit(ArticleForm form);
}
