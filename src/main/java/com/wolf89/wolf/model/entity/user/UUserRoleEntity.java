package com.wolf89.wolf.model.entity.user;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 用户授权角色.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wuser", name = "U_USER_ROLE")
@AttributeOverride(
        name = "id", column = @Column(name = "ur_id", length = 40)
)
public class UUserRoleEntity extends AbstractEntity {

    /**
     * 用户id.
     */
    @EntityInfo(name = "用户Id", value = "userId")
    @Column(name = "ur_userId", length = 40)
    private String userId;

    /**
     * 角色id.
     */
    @EntityInfo(name = "角色Id", value = "roleId")
    @Column(name = "ur_roleId", length = 40)
    private String roleId;

    /**
     * 有效期起.
     */
    @EntityInfo(name = "有效期起", value = "begin")
    @Column(name = "ur_begin")
    private LocalDateTime begin;

    /**
     * 有效期至.
     */
    @EntityInfo(name = "有效期至", value = "end")
    @Column(name = "ur_end")
    private LocalDateTime end;

    /**
     * 备注.
     */
    @Column(name = "ur_note", length = 100)
    @EntityInfo(name = "备注", value = "note")
    private String note;

    /**
     * Gets the value of userId.
     *
     * @return the value of userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     * <p>You can use getUserId() to get the value of userId.</p>
     *
     * @param userId userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of roleId.
     *
     * @return the value of roleId.
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the roleId.
     * <p>You can use getRoleId() to get the value of roleId.</p>
     *
     * @param roleId roleId.
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the value of begin.
     *
     * @return the value of begin.
     */
    public LocalDateTime getBegin() {
        return begin;
    }

    /**
     * Sets the begin.
     * <p>You can use getBegin() to get the value of begin.</p>
     *
     * @param begin begin.
     */
    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    /**
     * Gets the value of end.
     *
     * @return the value of end.
     */
    public LocalDateTime getEnd() {
        return end;
    }

    /**
     * Sets the end.
     * <p>You can use getEnd() to get the value of end.</p>
     *
     * @param end end.
     */
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * Gets the value of note.
     *
     * @return the value of note.
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the note.
     * <p>You can use getNote() to get the value of note.</p>
     *
     * @param note note.
     */
    public void setNote(String note) {
        this.note = note;
    }
}
