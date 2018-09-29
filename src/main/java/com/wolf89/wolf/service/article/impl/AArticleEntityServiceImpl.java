package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.core.service.AbstractEntityServiceImpl;
import com.wolf89.wolf.dao.article.AArticleEntityRepository;
import com.wolf89.wolf.dto.article.ArticleForm;
import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.model.entity.article.Article;
import com.wolf89.wolf.service.article.AArticleEntityService;
import com.wolf89.wolf.service.system.SClassifyEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * service实现.
 *
 * @author gaoweibing
 */
@Service
public class AArticleEntityServiceImpl extends AbstractEntityServiceImpl<AArticleEntity> implements AArticleEntityService {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleEntityServiceImpl.class);

    @Autowired
    private AArticleEntityRepository aArticleEntityRepository;

    @Autowired
    private SClassifyEntityService sClassifyEntityService;

    @Override
    public AbstractEntityRepository<AArticleEntity> getRepository() {
        return aArticleEntityRepository;
    }

    @Override
    public Class<AArticleEntity> getClazz() {
        return AArticleEntity.class;
    }

    /**
     * 提交.
     *
     * @param form 参数.
     * @return 成功信息.
     */
    @Override
    public ApiOutput<String> submit(ArticleForm form) {

        LOG.info("普通文章提交");

        AArticleEntity aArticleEntity = new AArticleEntity();

        aArticleEntity.setTitle(form.getTitle());
        aArticleEntity.setTags(form.getTags());
        aArticleEntity.setSubtitle(form.getSubtitle());
        aArticleEntity.setOpen(false);
        aArticleEntity.setContent(form.getContent());
        aArticleEntity.setColumn(form.getColumn());
        aArticleEntity.setAuthor(form.getAuthor());
        aArticleEntity.setType(form.getType());
        aArticleEntity.setControl(1);

        return null;

    }
}
