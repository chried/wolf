package com.wolf89.wolf.service.article.impl;

import com.wolf89.wolf.model.entity.article.AColumnEntity;
import com.wolf89.wolf.model.entity.article.Article;
import com.wolf89.wolf.model.entity.system.SClassifyEntity;
import com.wolf89.wolf.service.article.AColumnEntityService;
import com.wolf89.wolf.service.article.AbstractArticleEntityService;
import com.wolf89.wolf.service.system.SClassifyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 实现.
 *
 * @author chried
 */
@Service
public class AbstractArticleEntityServiceImpl implements AbstractArticleEntityService {

    @Autowired
    private AColumnEntityService aColumnEntityService;

    @Autowired
    private SClassifyEntityService sClassifyEntityService;

    /**
     * 提交前操作.
     *
     * @param article 文章对象.
     */
    @Override
    public void beforeSave_(Article article) {

        if (article.getColumn() != null) {

            AColumnEntity aColumnEntity = aColumnEntityService.get_(article.getColumn().getId());

            if (aColumnEntity != null) {
                article.setColumn(aColumnEntity.toRefer());
            }
        }

        if (article.getType() != null) {

            SClassifyEntity typeClassify = this.sClassifyEntityService.findByCode_(article.getType().getCode());

            if (typeClassify != null) {
                article.setType(typeClassify.toType());
            }
        }

    }
}
