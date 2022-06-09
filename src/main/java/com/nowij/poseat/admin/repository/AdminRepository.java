package com.nowij.poseat.admin.repository;

import com.nowij.poseat.admin.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Object> {
    int countByIdAndPw(@Param("id") String id, @Param("pw") String pw);

    @Query(value = "select user.tbCnt from AdminEntity user where user.id = :id")
    Integer findTbCnt(@Param("id") String id);

    AdminEntity findAllById(@Param("id") String id);

    List<AdminEntity> findAll();
}
