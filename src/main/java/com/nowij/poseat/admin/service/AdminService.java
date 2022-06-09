package com.nowij.poseat.admin.service;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.admin.entity.AdminEntity;

public interface AdminService {
    void seatNumberSave(AdminVO vo);
    AdminEntity adminInfo(String id);
}
