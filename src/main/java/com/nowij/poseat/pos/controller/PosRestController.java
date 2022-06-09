package com.nowij.poseat.pos.controller;

import com.nowij.poseat.admin.dto.AdminVO;
import com.nowij.poseat.pos.dto.KafkaVO;
import com.nowij.poseat.pos.entity.PosEntity;
import com.nowij.poseat.pos.service.PosServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PosRestController {

    public PosServiceImpl service;

    @PostMapping("/login.do")
    public int login(@RequestBody AdminVO vo) {
        return service.login(vo);
    }

    @PostMapping("/show/table.do")
    public int showTable(HttpSession session) {
        String id = session.getAttribute("admin").toString();
        return service.showTableCount(id);
    }

    @PostMapping("/menuList.do")
    public List<PosEntity> showMenu() {
        return service.showMenu();
    }

    @PostMapping("/kafka.do")
    public void sendKafka(@RequestBody KafkaVO vo) {

    }

}
