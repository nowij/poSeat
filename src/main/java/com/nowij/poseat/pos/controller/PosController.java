package com.nowij.poseat.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PosController {

    @RequestMapping("/pos")
    public String pos() {
        return "pos";
    }
}
