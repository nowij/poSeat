package com.nowij.poseat.pos.entity;

import com.nowij.poseat.pos.dto.LoginVO;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column
    private String pw;

    @Column
    private String tableCount;

    public LoginEntity() {
    }

    public LoginEntity(LoginVO vo) {
        id = vo.getId();
        pw = vo.getPw();
        tableCount = vo.getTableCount();
    }
}
