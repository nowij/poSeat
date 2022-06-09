package com.nowij.poseat.pos.service;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.admin.repository.AdminRepository;
import com.nowij.poseat.pos.entity.PosEntity;
import com.nowij.poseat.pos.repository.PosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosServiceImpl implements PosService {

    private final AdminRepository adminRepository;
    private final PosRepository posRepository;

    @Autowired
    public PosServiceImpl(AdminRepository adminRepository, PosRepository posRepository) {
        this.adminRepository = adminRepository;
        this.posRepository = posRepository;
    }

    @Override
    public int login(AdminVO vo) {
        String id = vo.getId();
        String pw = vo.getPw();
        return adminRepository.countByIdAndPw(id, pw);
    }

    @Override
    public int showTableCount(String id) {
        Integer result = adminRepository.findTbCnt(id);
        if (result == null)
            return 0;
        return result;
    }

    @Override
    public List<PosEntity> showMenu() {
        return posRepository.findAll();
    }
}
