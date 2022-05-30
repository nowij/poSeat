package com.nowij.poseat.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin.do")
    public String adminPage(Model model, String id) {
        model.addAttribute("adminId", id);
        return "admin";
    }
}
