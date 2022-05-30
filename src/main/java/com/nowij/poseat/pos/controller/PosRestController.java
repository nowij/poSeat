package com.nowij.poseat.pos.controller;

import com.nowij.poseat.pos.dto.LoginVO;
import com.nowij.poseat.pos.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PosRestController {

    @Autowired
    LoginRepository repository;

    @PostMapping("/login.do")
    public int login(@RequestBody LoginVO vo) throws Exception {
        return repository.countByIdAndPw(vo.getId(), vo.getPw());
    }

    @RequestMapping("/show.do")
    public int showTable(String id) throws Exception {
        Integer result = repository.findTbCnt(id);
        if (result == null)
            return 0;
        return result;
    }
}
