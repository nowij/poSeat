package com.nowij.poseat.admin.controller;

import com.nowij.poseat.pos.dto.UserVO;
import com.nowij.poseat.pos.entity.UsertEntity;
import com.nowij.poseat.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class AdminRestController {

    @Autowired
    UserRepository repository;

    @PostMapping("/tableSave.do")
    @Transactional
    public void tableCount(@RequestBody UserVO vo) throws Exception {
        UsertEntity entity = repository.findAllById(vo.getId());
        entity.setTbCnt(vo.getTbCnt());
        repository.save(entity);
    }
}
