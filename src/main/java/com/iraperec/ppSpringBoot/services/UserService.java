package com.iraperec.ppSpringBoot.services;

import com.iraperec.ppSpringBoot.dao.UserDAO;
import com.iraperec.ppSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
