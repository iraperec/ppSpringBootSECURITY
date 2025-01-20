package com.iraperec.ppSpringBoot.dao;


import com.iraperec.ppSpringBoot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDAO{
    List<Role> getRoles();
    Role findByName(String name);
}
