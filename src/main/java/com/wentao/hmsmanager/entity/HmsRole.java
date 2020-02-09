package com.wentao.hmsmanager.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hms_role")
public class HmsRole {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToMany(targetEntity = HmsPermission.class)
    @JoinTable(name = "hms_role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<HmsPermission> permissions;

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

    public Set<HmsPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<HmsPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsRole hmsRole = (HmsRole) o;
        return Objects.equals(id, hmsRole.id) &&
                Objects.equals(name, hmsRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
