package com.nowij.poseat.web.controller;

import com.nowij.poseat.admin.entity.AdminEntity;
import com.nowij.poseat.admin.repository.AdminRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    private final AdminRepository repository;

    public WebController(AdminRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/web")
    public String webPage(Model model) {
        List<AdminEntity> list = repository.findAll();
        model.addAttribute("restList", list);
        return "web";
    }
}
