package com.nowij.poseat.pos.repository;

import com.nowij.poseat.pos.entity.UsertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsertEntity, Object> {
    int countByIdAndPw(@Param("id") String id, @Param("pw") String pw);

    @Query(value = "select tbCnt from UsertEntity where id = :id")
    Integer findTbCnt(@Param("id") String id);

    UsertEntity findAllById(@Param("id") String id);
//    @Transactional
//    int updateTbleCnt(@Param("cnt") int cnt, @Param("id") String id);
}
