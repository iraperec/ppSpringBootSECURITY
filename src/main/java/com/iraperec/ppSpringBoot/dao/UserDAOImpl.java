package com.iraperec.ppSpringBoot.dao;

import com.iraperec.ppSpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(show(id));
    }

    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        Optional<User> user;
        try {
            user = Optional.of(entityManager.createQuery("select u from User u where username=?1", User.class)
                    .setParameter(1, username)
                    .getSingleResult());
        } catch (NoResultException e) {
            user = Optional.empty();
        }
        return user;
    }
}
