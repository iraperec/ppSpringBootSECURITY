package com.iraperec.ppSpringBoot.dao;

import com.iraperec.ppSpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import java.util.List;

@Component
public class UserDAO implements IntDAO{

    @Autowired
    @PersistenceContext
    EntityManager entityManager;


    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    public User show(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public void save(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    public void update(User user) {
        entityManager.merge(user);

    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
