package com.nowij.poseat.pos.controller;

import com.nowij.poseat.pos.dto.LoginVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PosRestController {

    @RequestMapping("/login.do")
    public int login(LoginVO vo) {
        return 0;
    }

    @RequestMapping("/show.do")
    public void showTable() {
        // TODO 좌석 현황을 보여주는 기능
    }
}
