package com.nowij.poseat.pos.entity;

import com.nowij.poseat.pos.dto.UserVO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DynamicUpdate
@Table(name = "pos_user")
public class UsertEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "pw")
    private String pw;

    @Column(name = "tb_cnt")
    private Integer tbCnt;

    public UsertEntity() {
    }

    public UsertEntity(UserVO vo) {
        id = vo.getId();
        pw = vo.getPw();
        tbCnt = vo.getTbCnt();
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
}