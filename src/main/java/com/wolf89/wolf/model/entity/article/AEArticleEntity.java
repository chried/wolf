package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 英文翻译相关.
 *
 * @author chried
 */
@Entity
@Table(schema = "warticle", name = "A_E_ARTICLE")
@AttributeOverride(name = "id", column = @Column(name = "ea_id", length = 40, updatable = false))
public class AEArticleEntity extends Article {

    @EntityInfo(name = "来源", value = "source")
    @Column(name = "ea_source", length = 50)
    private String source;

    @EntityInfo(name = "链接", value = "link")
    @Column(name = "ea_link", length = 200)
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
