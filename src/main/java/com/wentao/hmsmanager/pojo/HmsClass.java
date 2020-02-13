package com.wentao.hmsmanager.pojo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class HmsClass implements Serializable {

    private Integer id;
    private String name;
    private Set<HmsUser> students;
    private Set<HmsCourse> courses;

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

    public Set<HmsUser> getStudents() {
        return students;
    }

    public Set<HmsCourse> getCourses() {
        return courses;
    }

    public void setCourses(Set<HmsCourse> courses) {
        this.courses = courses;
    }

    public void setStudents(Set<HmsUser> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsClass hmsClass = (HmsClass) o;
        return Objects.equals(id, hmsClass.id) &&
                Objects.equals(name, hmsClass.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
