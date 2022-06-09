package com.nowij.poseat.pos.service;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.pos.entity.PosEntity;

import java.util.List;

public interface PosService {
    int login(AdminVO vo);
    int showTableCount(String id);
    List<PosEntity> showMenu();
}
