package com.iraperec.ppSpringBoot.service;

import com.iraperec.ppSpringBoot.dao.RoleDAO;
import com.iraperec.ppSpringBoot.dao.RoleRepository;
import com.iraperec.ppSpringBoot.model.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleDAO roleDAO, RoleRepository roleRepository) {
        this.roleDAO = roleDAO;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<Role> getRoles() {
        return roleDAO.getRoles();
    }

    @Override
    public Role findByName(String name) {
        return roleDAO.findByName(name);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
