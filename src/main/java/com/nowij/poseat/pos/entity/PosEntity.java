package com.nowij.poseat.pos.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pos_menu")
public class PosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_name")
    private String menuName;

    public PosEntity() {
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
