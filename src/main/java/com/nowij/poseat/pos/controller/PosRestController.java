package com.nowij.poseat.pos.controller;

import com.nowij.poseat.pos.dto.KafkaVO;
import com.nowij.poseat.pos.dto.UserVO;
import com.nowij.poseat.pos.entity.PosEntity;
import com.nowij.poseat.pos.repository.PosRepository;
import com.nowij.poseat.pos.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class PosRestController {

    private UserRepository userRepository;
    private PosRepository posRepository;

    public PosRestController(UserRepository userRepository, PosRepository posRepository) {
        this.userRepository = userRepository;
        this.posRepository = posRepository;
    }

    @PostMapping("/login.do")
    public int login(@RequestBody UserVO vo) {
        return userRepository.countByIdAndPw(vo.getId(), vo.getPw());
    }

    @PostMapping("/show/table.do")
    public int showTable(HttpSession session) {
        String id = session.getAttribute("admin").toString();
        Integer result = userRepository.findTbCnt(id);
        if (result == null)
            return 0;
        return result;
    }

    @PostMapping("/menuList.do")
    public List<PosEntity> showMenu() {
        return posRepository.findAll();
    }

    @PostMapping("/kafka.do")
    public void sendKafka(@RequestBody KafkaVO vo) {

    }

}
