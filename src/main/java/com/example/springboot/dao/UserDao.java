package com.example.springboot.dao;



import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void delete(int id);

    User getById(int id);

    List<User> getAllUsers();


}

