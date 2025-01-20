package com.iraperec.ppSpringBoot.service;

import com.iraperec.ppSpringBoot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void delete(long id);
    List<User> index();
    User show(long id);
}
