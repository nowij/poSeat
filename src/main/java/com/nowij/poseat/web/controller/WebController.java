package com.nowij.poseat.web.controller;

import com.nowij.poseat.pos.entity.UserEntity;
import com.nowij.poseat.pos.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {

    private UserRepository repository;

    public WebController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/web")
    public String webPage(Model model) {
        List<UserEntity> list = repository.findAll();
        model.addAttribute("restList", list);
        return "web";
    }
}
