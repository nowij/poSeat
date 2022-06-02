package com.nowij.poseat.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @RequestMapping("/admin.do")
    public String adminPage() {
        return "admin";
    }
}
