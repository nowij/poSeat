package com.nowij.poseat.pos.repository;

import com.nowij.poseat.pos.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Object> {
    int countByIdAndPw(@Param("id") String id, @Param("pw") String pw);

    @Query(value = "select tbCnt from LoginEntity where id = :id")
    Integer findTbCnt(@Param("id") String id);

    LoginEntity findAllById(@Param("id") String id);
//    @Transactional
//    int updateTbleCnt(@Param("cnt") int cnt, @Param("id") String id);
}
