package com.wolf89.wolf.model.entity.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.entity.Value;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import java.util.List;

/**
 * 定义文章父级.
 *
 * @author gaoweibing
 */
public abstract class Article extends AbstractEntity {

    @EntityInfo(name = "标题", value = "title")
    @Column(name = "a_title", length = 100)
    private String title;

    @EntityInfo(name = "副标题", value = "subtitle")
    @Column(name = "a_subtitle", length = 50)
    private String subtitle;

    @EntityInfo(name = "作者", value = "author")
    @AttributeOverrides(value = {
            @AttributeOverride(name = "id", column = @Column(name = "a_author_id")),
            @AttributeOverride(name = "code", column = @Column(name = "a_author_code")),
            @AttributeOverride(name = "name", column = @Column(name = "a_author_name"))
    })
    private Refer author;

    @Type(type = "jsonb")
    @Column(name = "a_tags")
    @EntityInfo(name = "标签", value = "tags", clazz = "java.util.List")
    private List<Value> tags;

    @EntityInfo(name = "内容", value = "content")
    @Column(name = "a_content", columnDefinition = "text")
    private String content;

    /**
     * <pre>
     *     1、草稿;
     *     3、驳回;
     *     4、冻结;
     *     5、正常;
     *     7、作废;
     *     9、永久冻结(违反操作);
     * </pre>
     */
    @EntityInfo(name = "状态", value = "control")
    @Column(name = "a_control", columnDefinition = "int2")
    private int control;

    /**
     * Gets the value of title.
     *
     * @return the value of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     * <p>You can use getTitle() to get the value of title.</p>
     *
     * @param title title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of subtitle.
     *
     * @return the value of subtitle.
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * Sets the subtitle.
     * <p>You can use getSubtitle() to get the value of subtitle.</p>
     *
     * @param subtitle subtitle.
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * Gets the value of author.
     *
     * @return the value of author.
     */
    public Refer getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     * <p>You can use getAuthor() to get the value of author.</p>
     *
     * @param author author.
     */
    public void setAuthor(Refer author) {
        this.author = author;
    }

    /**
     * Gets the value of tags.
     *
     * @return the value of tags.
     */
    public List<Value> getTags() {
        return tags;
    }

    /**
     * Sets the tags.
     * <p>You can use getTags() to get the value of tags.</p>
     *
     * @param tags tags.
     */
    public void setTags(List<Value> tags) {
        this.tags = tags;
    }

    /**
     * Gets the value of content.
     *
     * @return the value of content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content.
     * <p>You can use getContent() to get the value of content.</p>
     *
     * @param content content.
     */
    public void setContent(String content) {
        this.content = content;
    }
}
