package com.nowij.poseat.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PosController {

    @RequestMapping("/")
    public String main(HttpSession session) {
        String id = (String) session.getAttribute("admin");
        if (id != null) {
            session.removeAttribute("admin");
        }
        return "main";
    }

    @RequestMapping("/pos.do")
    public String pos(String id, HttpSession session) {
        session.setAttribute("admin", id);
        return "pos";
    }
}
