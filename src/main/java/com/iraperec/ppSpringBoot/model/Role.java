package com.iraperec.ppSpringBoot.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
@Data
@Table(name= "roles")
public class Role implements GrantedAuthority {

    public Role(String name) {
        this.name = name;
    }
    public Role() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @Override
    public String getAuthority() {
        return "ROLE_" + name;

    }
}
