package com.wolf89.wolf.dto.article;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Refer;
import com.wolf89.wolf.core.entity.Type;
import com.wolf89.wolf.core.entity.Value;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

/**
 * 定义文章父级.
 *
 * @author gaoweibing
 */
public class ArticleForm implements Serializable {

    @EntityInfo(name = "标题", value = "title")
    private String title;

    @EntityInfo(name = "副标题", value = "subtitle")
    private String subtitle;

    @EntityInfo(name = "分类", value = "type", clazz = "com.wolf89.wolf.core.entity.Type")
    private Type type;

    @EntityInfo(name = "作者", value = "author")
    private Refer author;

    @EntityInfo(name = "栏目", value = "column")
    private Refer column;

    @org.hibernate.annotations.Type(type = "jsonb")
    @EntityInfo(name = "标签", value = "tags", clazz = "java.util.List")
    private List<Value> tags;

    @EntityInfo(name = "内容", value = "content")
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

    /**
     * Gets the value of type.
     *
     * @return the value of type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the type.
     * <p>You can use getType() to get the value of type.</p>
     *
     * @param type type.
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Gets the value of control.
     *
     * @return the value of control.
     */
    public int getControl() {
        return control;
    }

    /**
     * Sets the control.
     * <p>You can use getControl() to get the value of control.</p>
     *
     * @param control control.
     */
    public void setControl(int control) {
        this.control = control;
    }

    /**
     * Gets the value of column.
     *
     * @return the value of column.
     */
    public Refer getColumn() {
        return column;
    }

    /**
     * Sets the column.
     * <p>You can use getColumn() to get the value of column.</p>
     *
     * @param column column.
     */
    public void setColumn(Refer column) {
        this.column = column;
    }
}
