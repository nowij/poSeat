package com.nowij.poseat.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PosController {

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/pos.do")
    public String pos(String id, Model model) {
        model.addAttribute("admin", id);
        return "pos";
    }
}
