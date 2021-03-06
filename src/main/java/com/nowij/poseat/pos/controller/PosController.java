package com.nowij.poseat.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PosController {

    @RequestMapping("/")
    public String mainPage(HttpSession session) {
        String id = (String) session.getAttribute("admin");
        if (id != null) {
            session.invalidate();
        }
        return "main";
    }

    @RequestMapping("/pos.do")
    public String posPage(String id, HttpSession session) {
        session.setAttribute("admin", id);
        return "pos";
    }

    @RequestMapping("/menu.do")
    public String menuPage() {
        return "menu";
    }
}
