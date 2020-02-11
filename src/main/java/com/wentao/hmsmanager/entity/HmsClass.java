package com.wentao.hmsmanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hms_class")
public class HmsClass implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    @JsonBackReference("classStudent")
    @OneToMany(targetEntity = HmsUser.class)
    @JoinTable(name = "hms_user_class", joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<HmsUser> students;

    @JsonBackReference("classCourse")
    @OneToMany
    @JoinTable(name = "hms_class_course", joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<HmsCourse> courses;

    @JsonBackReference("classHomework")
    @OneToMany
    @JoinTable(name = "hms_class_homework", joinColumns = {@JoinColumn(name = "class_id")},
            inverseJoinColumns = {@JoinColumn(name = "homework_id")})
    private Set<HmsHomework> homeworks;

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

    public Set<HmsHomework> getHomeworks() {
        return homeworks;
    }

    public void setHomeworks(Set<HmsHomework> homeworks) {
        this.homeworks = homeworks;
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
