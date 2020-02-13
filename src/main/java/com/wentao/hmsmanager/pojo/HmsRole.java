package com.wentao.hmsmanager.pojo;

import java.util.Objects;
import java.util.Set;

public class HmsRole {

    private Integer id;
    private String name;
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
