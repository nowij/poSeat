package com.nowij.poseat.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin.do")
    public String adminPage() {
        return "admin";
    }
}
