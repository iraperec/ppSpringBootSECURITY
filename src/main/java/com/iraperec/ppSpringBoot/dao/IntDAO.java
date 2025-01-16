package com.iraperec.ppSpringBoot.dao;

import com.iraperec.ppSpringBoot.model.User;

import java.util.List;

public interface IntDAO{
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User user);
    void delete(int id);
}
