package com.wolf89.wolf.core.cache;

import com.wolf89.wolf.core.annotation.CacheInfo;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 父级缓存类.
 *
 * @author gaoweibing
 */
public class AbstractCache implements Serializable {

    @Id
    @CacheInfo(name = "主键", value = "id")
    private String id;

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
}
