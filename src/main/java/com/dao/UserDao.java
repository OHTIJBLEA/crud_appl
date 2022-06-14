package com.dao;

import com.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

}
