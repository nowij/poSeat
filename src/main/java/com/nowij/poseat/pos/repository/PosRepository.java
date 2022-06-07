package com.nowij.poseat.pos.repository;

import com.nowij.poseat.pos.entity.PosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PosRepository extends JpaRepository<PosEntity, Object> {
    List<PosEntity> findAll();
}
