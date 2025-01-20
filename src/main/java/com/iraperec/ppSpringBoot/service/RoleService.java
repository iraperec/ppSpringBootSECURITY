package com.iraperec.ppSpringBoot.service;

import com.iraperec.ppSpringBoot.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    Role findByName(String name);
    void saveRole(Role role);
}
