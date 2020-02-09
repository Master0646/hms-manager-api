package com.wentao.hmsmanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hms_course")
public class HmsCourse implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @JsonBackReference
    @ManyToMany(targetEntity = HmsClass.class)
    @JoinTable(name = "hms_class_course", joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")})
    private List<HmsClass> classes;

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

    public List<HmsClass> getClasses() {
        return classes;
    }

    public void setClasses(List<HmsClass> classes) {
        this.classes = classes;
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
