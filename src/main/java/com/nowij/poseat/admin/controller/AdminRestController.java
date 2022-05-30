package com.nowij.poseat.admin.controller;

import com.nowij.poseat.pos.dto.LoginVO;
import com.nowij.poseat.pos.entity.LoginEntity;
import com.nowij.poseat.pos.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class AdminRestController {

    @Autowired
    LoginRepository repository;

    @PostMapping("/tableSave.do")
    @Transactional
    public void tableCount(@RequestBody LoginVO vo) throws Exception {
        LoginEntity entity = repository.findAllById(vo.getId());
        entity.setTbCnt(vo.getTbCnt());
        repository.save(entity);
    }
}
