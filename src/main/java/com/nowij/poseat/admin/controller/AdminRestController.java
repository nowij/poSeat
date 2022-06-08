package com.nowij.poseat.admin.controller;

import com.nowij.poseat.pos.dto.UserVO;
import com.nowij.poseat.pos.entity.UserEntity;
import com.nowij.poseat.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@RestController
public class AdminRestController {

    @Autowired
    UserRepository repository;

    @PostMapping("/countSave.do")
    @Transactional
    public void countSave(@RequestBody UserVO vo, HttpSession session) {
        String id = session.getAttribute("admin").toString();
        UserEntity entity = repository.findAllById(id);
        entity.setId(id);
        entity.setTbCnt(vo.getTbCnt());
        repository.save(entity);
    }

    @PostMapping("/adminInfo.do")
    public UserEntity adminInfo(HttpSession session) {
        String id = session.getAttribute("admin").toString();
        return repository.findAllById(id);
    }
}
