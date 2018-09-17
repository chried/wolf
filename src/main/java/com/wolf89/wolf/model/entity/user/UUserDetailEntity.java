package com.wolf89.wolf.model.entity.user;

import com.wolf89.wolf.core.annotation.EntityInfo;
import com.wolf89.wolf.core.entity.AbstractEntity;
import com.wolf89.wolf.core.entity.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 用户详情.
 *
 * @author chried
 */
@Entity
@Table(schema = "wuser", name = "U_USER_DETAIL")
@AttributeOverride(
        name = "id", column = @Column(name = "ud_id", length = 40)
)
public class UUserDetailEntity extends AbstractEntity {

    @EntityInfo(name = "昵称", value = "nickname")
    @Column(name = "ud_nickname", length = 40)
    private String nickname;

    @AttributeOverrides({
            @AttributeOverride(
                    name = "code", column = @Column(name = "ud_sex_code", length = 50)
            ),
            @AttributeOverride(
                    name = "name", column = @Column(name = "ud_sex_name", length = 50)
            )
    })
    @EntityInfo(name = "性别", value = "性别", clazz = "com.wolf89.wolf.core.entity.Type")
    @Embedded
    private Type sex;

    @EntityInfo(name = "生日", value = "birthday")
    @Column(name = "ud_birthday")
    private LocalDate birthday;

    @org.hibernate.annotations.Type(type = "jsonb")
    @Column(name = "ud_hobbys", columnDefinition = "jsonb")
    @EntityInfo(name = "爱好", value = "hobby")
    private List<Type> hobbys;

    @EntityInfo(name = "头像", value = "portrait")
    private String portrait;

    @EntityInfo(name = "签名", value = "signature")
    private String signature;

    @org.hibernate.annotations.Type(type = "jsonb")
    @Column(name = "ud_im", columnDefinition = "jsonb")
    @EntityInfo(name = "通讯", value = "im")
    private Map<String, String> im;

    /**
     * Gets the value of nickname.
     *
     * @return the value of nickname.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname.
     * <p>You can use getNickname() to get the value of nickname.</p>
     *
     * @param nickname nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Gets the value of sex.
     *
     * @return the value of sex.
     */
    public Type getSex() {
        return sex;
    }

    /**
     * Sets the sex.
     * <p>You can use getSex() to get the value of sex.</p>
     *
     * @param sex sex.
     */
    public void setSex(Type sex) {
        this.sex = sex;
    }

    /**
     * Gets the value of birthday.
     *
     * @return the value of birthday.
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday.
     * <p>You can use getBirthday() to get the value of birthday.</p>
     *
     * @param birthday birthday.
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the value of hobbys.
     *
     * @return the value of hobbys.
     */
    public List<Type> getHobbys() {
        return hobbys;
    }

    /**
     * Sets the hobbys.
     * <p>You can use getHobbys() to get the value of hobbys.</p>
     *
     * @param hobbys hobbys.
     */
    public void setHobbys(List<Type> hobbys) {
        this.hobbys = hobbys;
    }

    /**
     * Gets the value of portrait.
     *
     * @return the value of portrait.
     */
    public String getPortrait() {
        return portrait;
    }

    /**
     * Sets the portrait.
     * <p>You can use getPortrait() to get the value of portrait.</p>
     *
     * @param portrait portrait.
     */
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    /**
     * Gets the value of signature.
     *
     * @return the value of signature.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the signature.
     * <p>You can use getSignature() to get the value of signature.</p>
     *
     * @param signature signature.
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * Gets the value of im.
     *
     * @return the value of im.
     */
    public Map<String, String> getIm() {
        return im;
    }

    /**
     * Sets the im.
     * <p>You can use getIm() to get the value of im.</p>
     *
     * @param im im.
     */
    public void setIm(Map<String, String> im) {
        this.im = im;
    }
}
