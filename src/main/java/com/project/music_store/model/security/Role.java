package com.project.music_store.model.security;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    //tipuri de roluri : Super Admin, Administrator, Editor, Author, Contributor, and Subscriber
    @Id
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name")
    private String name;

    //un rol poate fi detinut de mai multi useri -> se va genera o lista de userRoluri
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserRole> userRoles = new HashSet<UserRole>();


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
