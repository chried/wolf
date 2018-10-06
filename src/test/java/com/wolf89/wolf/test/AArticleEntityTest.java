package com.wolf89.wolf.test;


import com.wolf89.wolf.model.entity.article.AArticleEntity;
import com.wolf89.wolf.service.article.AArticleEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AArticleEntityTest.class)
@ComponentScan(value = "com.wolf89.wolf")
public class AArticleEntityTest {

    private static final Logger LOG = LoggerFactory.getLogger(AArticleEntityTest.class);

    @Autowired
    private AArticleEntityService aArticleEntityService;

    @Test
    public void test_add() {

        AArticleEntity aArticleEntity = new AArticleEntity();

        aArticleEntityService.save(aArticleEntity);

    }
}
