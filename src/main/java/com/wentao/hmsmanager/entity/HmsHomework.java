package com.wentao.hmsmanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hms_homework")
public class HmsHomework {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String content;

    @JsonBackReference("homeworkCourse")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "hms_course_homework", joinColumns = {@JoinColumn(name = "homework_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private HmsCourse courses;

    @JsonBackReference("homeworkClass")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "hms_class_homework", joinColumns = {@JoinColumn(name = "homework_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")})
    private HmsClass classes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HmsCourse getCourses() {
        return courses;
    }

    public void setCourses(HmsCourse courses) {
        this.courses = courses;
    }

    public HmsClass getClasses() {
        return classes;
    }

    public void setClasses(HmsClass classes) {
        this.classes = classes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsHomework that = (HmsHomework) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, content);
    }
}
