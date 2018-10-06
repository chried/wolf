package com.wolf89.wolf.service.article;

import com.wolf89.wolf.model.entity.article.Article;

/**
 * 文章抽象类.
 * 实现文章公用操作.
 *
 * @author chried
 */
public interface AbstractArticleEntityService {

    /**
     * 提交前操作.
     *
     * @param article 文章对象.
     */
    void beforeSave_(Article article);
}
