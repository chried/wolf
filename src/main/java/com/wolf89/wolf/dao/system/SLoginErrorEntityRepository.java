package com.wolf89.wolf.dao.system;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.model.entity.system.SLoginErrorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * dao.
 *
 * @author gaoweibing
 */
@Repository
public interface SLoginErrorEntityRepository extends AbstractEntityRepository<SLoginErrorEntity> {

    /**
     * 根据userId获取.
     *
     * @param userId 用户id.
     * @return 错误对象.
     */
    @Query("SELECT L FROM SLoginErrorEntity L WHERE L.userId = :userId " +
            " AND L.status_ = :status_")
    SLoginErrorEntity findByUserId(@Param("userId") String userId, @Param("status_") String status_);

    /**
     * 根据userId删除.
     *
     * @param userId 用户id.
     */
    @Query("DELETE FROM SLoginErrorEntity L WHERE L.userId = :userId")
    @Modifying
    void deleteByUserId(@Param("userId") String userId);
}
