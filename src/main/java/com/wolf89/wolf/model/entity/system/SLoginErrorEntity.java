package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.*;

/**
 * 登录错误实体类.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wsystem", name = "S_LOGIN_ERROR")
@AttributeOverride(
        name = "id", column = @Column(name = "l_id", length = 40)
)
public class SLoginErrorEntity extends AbstractEntity {

    /**
     * 用户id.
     */
    @EntityInfo(name = "用户ID", value = "userId")
    @Column(name = "l_userId", length = 40)
    private String userId;

    /**
     * 错误次数.
     */
    @EntityInfo(name = "错误次数", value = "error")
    @Column(name = "l_error", length = 2)
    private int error;

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
     * Gets the value of error.
     *
     * @return the value of error.
     */
    public int getError() {
        return error;
    }

    /**
     * Sets the error.
     * <p>You can use getError() to get the value of error.</p>
     *
     * @param error error.
     */
    public void setError(int error) {
        this.error = error;
    }
}
