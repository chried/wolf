package com.wolf89.wolf.model.entity.system;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 登录消息.
 *
 * @author gaoweibing
 */
@Entity
@Table(schema = "wsystem", name = "S_LOGIN_INFO")
@AttributeOverride(
        name = "id", column = @Column(name = "li_id", length = 40)
)
public class SLoginInfoEntity extends AbstractEntity {

    /**
     * 用户id.
     */
    @EntityInfo(name = "用户id", value = "userId")
    @Column(name = "li_userId", length = 40)
    private String userId;

    /**
     * 类型.
     */
    @EntityInfo(name = "类型", value = "type", note = "例如，网页(site)、ios,android")
    @Column(name = "li_type", length = 40)
    private String type;

    /**
     * 地址.
     */
    @EntityInfo(name = "地址", value = "address")
    @Column(name = "li_address", length = 40)
    private String address;

    /**
     * ip.
     */
    @Column(name = "ip", length = 20)
    @EntityInfo(name = "ip", value = "ip")
    private String ip;

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
     * Gets the value of type.
     *
     * @return the value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     * <p>You can use getType() to get the value of type.</p>
     *
     * @param type type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the value of address.
     *
     * @return the value of address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     * <p>You can use getAddress() to get the value of address.</p>
     *
     * @param address address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the value of ip.
     *
     * @return the value of ip.
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the ip.
     * <p>You can use getIp() to get the value of ip.</p>
     *
     * @param ip ip.
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
}
