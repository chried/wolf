package com.wolf89.wolf.dao.user;

import com.wolf89.wolf.core.dao.AbstractEntityRepository;
import com.wolf89.wolf.model.entity.user.UUserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * user dao.
 *
 * @author chried
 */
@Repository
public interface UUserEntityRepository extends AbstractEntityRepository<UUserEntity> {

    /**
     * 获取用户.
     *
     * @param name    可以是用户名、电话、邮箱.
     * @param status_ 状态.
     * @return 用户.
     */
    @Query("SELECT U FROM UUserEntity  U " +
            "WHERE U.status_ = :status_" +
            " AND (U.phone = :name OR U.email = :name OR U.username = :name)")
    UUserEntity findByName(@Param("name") String name, @Param("status_") String status_);
}
