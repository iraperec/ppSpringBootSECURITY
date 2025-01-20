package com.iraperec.ppSpringBoot.dao;

import com.iraperec.ppSpringBoot.model.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("select r from Role r", Role.class).getResultList();
    }

    @Override
    public Role findByName(String name) {
        return entityManager
                .createQuery("select r from Role r where name = ?1", Role.class)
                .setParameter(1, name)
                .getSingleResult();
    }
}
