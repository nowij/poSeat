package com.nowij.poseat.pos.dto;

public class UserVO {
    private String id;
    private String pw;
    private Integer tbCnt = 0;
    private String name;

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public Integer getTbCnt() {
        return tbCnt;
    }

    public String getName() {
        return name;
    }
}
