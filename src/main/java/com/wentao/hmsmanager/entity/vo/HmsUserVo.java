package com.wentao.hmsmanager.entity.vo;

import com.wentao.hmsmanager.pojo.HmsRole;

public class HmsUserVo {

    private Integer id;
    private String name;
    private HmsRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HmsRole getRole() {
        return role;
    }

    public void setRole(HmsRole role) {
        this.role = role;
    }
}
