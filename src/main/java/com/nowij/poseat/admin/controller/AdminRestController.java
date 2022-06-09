package com.nowij.poseat.admin.controller;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.admin.entity.AdminEntity;
import com.nowij.poseat.admin.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@RestController
public class AdminRestController {

    public AdminService service;

    @PostMapping("/seatSave.do")
    @Transactional
    public void countSave(@RequestBody AdminVO vo) {
        service.seatNumberSave(vo);
    }

    @PostMapping("/adminInfo.do")
    public AdminEntity adminInfo(HttpSession session) {
        String id = session.getAttribute("admin").toString();
        return service.adminInfo(id);
    }
}
