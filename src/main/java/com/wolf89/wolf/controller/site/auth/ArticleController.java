package com.wolf89.wolf.controller.site.auth;

import com.wolf89.wolf.core.output.ApiOutput;
import com.wolf89.wolf.dto.article.ArticleForm;
import com.wolf89.wolf.service.article.AArticleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章相关控制器.
 *
 * @author gaoweibing
 */
@RestController
@RequestMapping(value = "rest/auth/article")
public class ArticleController {

    private static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private AArticleEntityService aArticleEntityService;

    /**
     * 文章提交.
     *
     * @return
     */
    @RequestMapping(value = "submit")
    public ApiOutput<String> submitArticle(@RequestBody @Validated ArticleForm form, BindingResult result) {

        return this.aArticleEntityService.save(form);

    }

}
