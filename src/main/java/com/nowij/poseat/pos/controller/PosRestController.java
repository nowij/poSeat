package com.nowij.poseat.pos.controller;

import com.nowij.poseat.pos.dto.UserVO;
import com.nowij.poseat.pos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class PosRestController {

    @Autowired
    UserRepository repository;

    @PostMapping("/login.do")
    public int login(@RequestBody UserVO vo) {
        return repository.countByIdAndPw(vo.getId(), vo.getPw());
    }

    @PostMapping("/show.do")
    public int showTable(HttpSession session) {
        String id = session.getAttribute("admin").toString();
        Integer result = repository.findTbCnt(id);
        if (result == null)
            return 0;
        return result;
    }
}
