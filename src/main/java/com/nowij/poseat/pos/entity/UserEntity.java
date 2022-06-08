package com.nowij.poseat.pos.entity;

import com.nowij.poseat.pos.dto.UserVO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "pos_user")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "pw")
    private String pw;

    @Column(name = "tb_cnt")
    private Integer tbCnt;

    @Column(name = "name")
    private String name;

    public UserEntity() {
    }

    public UserEntity(UserVO vo) {
        id = vo.getId();
        pw = vo.getPw();
        tbCnt = vo.getTbCnt();
        name = vo.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Integer getTbCnt() {
        return tbCnt;
    }

    public void setTbCnt(Integer tbCnt) {
        this.tbCnt = tbCnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
