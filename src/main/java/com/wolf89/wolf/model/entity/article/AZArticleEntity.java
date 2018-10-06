package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 转载文章.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_Z_ARTICLE")
@AttributeOverride(name = "id", column = @Column(name = "ez_id", length = 40, updatable = false))
public class AZArticleEntity extends Article {

    @EntityInfo(name = "来源", value = "source")
    @Column(name = "ez_source", length = 50)
    private String source;

    @Column(name = "ez_link", length = 200)
    @EntityInfo(name = "链接", value = "link")
    private String link;

    /**
     * Gets the value of source.
     *
     * @return the value of source.
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the source.
     * <p>You can use getSource() to get the value of source.</p>
     *
     * @param source source.
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Gets the value of link.
     *
     * @return the value of link.
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link.
     * <p>You can use getLink() to get the value of link.</p>
     *
     * @param link link.
     */
    public void setLink(String link) {
        this.link = link;
    }
}
