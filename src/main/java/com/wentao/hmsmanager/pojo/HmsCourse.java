package com.wentao.hmsmanager.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class HmsCourse implements Serializable {

    private Integer id;
    private String name;
    private String description;
    private HmsUser lecturer;
    private List<HmsHomework> homeworks;

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

    public List<HmsHomework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(List<HmsHomework> homeworks) {
        this.homeworks = homeworks;
    }

    public HmsUser getLecturer() {
        return lecturer;
    }

    public void setLecturer(HmsUser lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsCourse hmsCourse = (HmsCourse) o;
        return Objects.equals(id, hmsCourse.id) &&
                Objects.equals(name, hmsCourse.name) &&
                Objects.equals(description, hmsCourse.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
