package com.yinfeng.wms.domain;

import java.util.Set;

/**
 * @author jonas
 * @time 2020 07 11 10 46
 * @description: wms
 */

public class User {
    private Integer id;
    private String name;
    private String password;
    private String role;

    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
