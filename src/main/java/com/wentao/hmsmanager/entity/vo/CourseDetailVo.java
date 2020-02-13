package com.wentao.hmsmanager.entity.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wentao.hmsmanager.pojo.HmsHomework;

public class CourseDetailVo {

    private Integer id;
    private String name;
    private String description;
    private Page<HmsHomework> homeworkPage;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Page<HmsHomework> getHomeworkPage() {
        return homeworkPage;
    }

    public void setHomeworkPage(Page<HmsHomework> homeworkPage) {
        this.homeworkPage = homeworkPage;
    }
}
