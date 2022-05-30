package com.nowij.poseat.pos.repository;

import com.nowij.poseat.pos.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Object> {
    int countByIdAndPw(@Param("id") String id, @Param("pw") String pw);

    @Query(value = "select tbCnt from UserEntity where id = :id")
    Integer findTbCnt(@Param("id") String id);

    UserEntity findAllById(@Param("id") String id);
}
