package com.wentao.hmsmanager.pojo;

import java.util.Objects;

public class HmsPermission {

    private Integer id;
    private String name;
    private String route;

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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HmsPermission that = (HmsPermission) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(route, that.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, route);
    }
}
