package com.nowij.poseat.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminRestController {

    @RequestMapping("/tableCount.do")
    public void tableCount() {
        // TODO 좌석 총 개수 설정하는 기능
    }
}
