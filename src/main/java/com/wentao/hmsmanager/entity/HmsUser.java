package com.wentao.hmsmanager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "hms_user")
public class HmsUser implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String idNumber;
    @Column
    private int sex;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private String email;
    @JsonBackReference("hmsClass")
    @ManyToMany(targetEntity = HmsClass.class)
    @JoinTable(name = "hms_user_class", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")})
    private List<HmsClass> hmsClass;
    @OneToOne
    @JoinColumn(name = "role_id")
    private HmsRole role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public List<HmsClass> getHmsClass() {
        return hmsClass;
    }

    public void setHmsClass(List<HmsClass> hmsClass) {
        this.hmsClass = hmsClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HmsRole getRole() {
        return role;
    }

    public void setRole(HmsRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsUser hmsUser = (HmsUser) o;
        return sex == hmsUser.sex &&
                Objects.equals(id, hmsUser.id) &&
                Objects.equals(username, hmsUser.username) &&
                Objects.equals(password, hmsUser.password) &&
                Objects.equals(name, hmsUser.name) &&
                Objects.equals(idNumber, hmsUser.idNumber) &&
                Objects.equals(phone, hmsUser.phone) &&
                Objects.equals(address, hmsUser.address) &&
                Objects.equals(email, hmsUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, idNumber, sex, phone, address, email);
    }
}
