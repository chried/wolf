package com.wolf89.wolf.core.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import com.wolf89.wolf.core.annotation.EntityInfo;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 定义父级entity.
 *
 * @author chried
 */
@MappedSuperclass
@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        ),
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        ),
        @TypeDef(
                name = "jsonb",
                typeClass = JsonBinaryType.class
        ),
        @TypeDef(
                name = "jsonb-node",
                typeClass = JsonNodeBinaryType.class
        )
})
public abstract class AbstractEntity implements Serializable {

    @Id
    @EntityInfo(name = "主键", value = "id")
    private String id;

    @EntityInfo(name = "状态", value = "status")
    @Column(name = "x_status_", length = 10)
    private String status_;

    @EntityInfo(name = "创建时间", value = "insert_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "x_insert_")
    private LocalDateTime insert_;

    @EntityInfo(name = "更新时间", value = "update_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "x_update_")
    private LocalDateTime update_;

    @EntityInfo(name = "删除时间", value = "delete_")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "x_delete_")
    private LocalDateTime delete_;

    /**
     * Gets the value of id.
     *
     * @return the value of id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     * <p>You can use getId() to get the value of id.</p>
     *
     * @param id id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the value of status_.
     *
     * @return the value of status_.
     */
    public String getStatus_() {
        return status_;
    }

    /**
     * Sets the status_.
     * <p>You can use getStatus_() to get the value of status_.</p>
     *
     * @param status_ status_.
     */
    public void setStatus_(String status_) {
        this.status_ = status_;
    }

    /**
     * Gets the value of insert_.
     *
     * @return the value of insert_.
     */
    public LocalDateTime getInsert_() {
        return insert_;
    }

    /**
     * Sets the insert_.
     * <p>You can use getInsert_() to get the value of insert_.</p>
     *
     * @param insert_ insert_.
     */
    public void setInsert_(LocalDateTime insert_) {
        this.insert_ = insert_;
    }

    /**
     * Gets the value of update_.
     *
     * @return the value of update_.
     */
    public LocalDateTime getUpdate_() {
        return update_;
    }

    /**
     * Sets the update_.
     * <p>You can use getUpdate_() to get the value of update_.</p>
     *
     * @param update_ update_.
     */
    public void setUpdate_(LocalDateTime update_) {
        this.update_ = update_;
    }

    /**
     * Gets the value of delete_.
     *
     * @return the value of delete_.
     */
    public LocalDateTime getDelete_() {
        return delete_;
    }

    /**
     * Sets the delete_.
     * <p>You can use getDelete_() to get the value of delete_.</p>
     *
     * @param delete_ delete_.
     */
    public void setDelete_(LocalDateTime delete_) {
        this.delete_ = delete_;
    }
}
