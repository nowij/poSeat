package com.nowij.poseat.admin.service;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.admin.entity.AdminEntity;
import com.nowij.poseat.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository repository;

    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public void seatNumberSave(AdminVO vo) {
        AdminEntity entity = repository.findAllById(vo.getId());
        entity.setId(vo.getId());
        entity.setTbCnt(vo.getTbCnt());
        repository.save(entity);
    }

    @Override
    public AdminEntity adminInfo(String id) {
        return repository.findAllById(id);
    }
}
