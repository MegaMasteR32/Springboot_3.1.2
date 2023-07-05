package com.example.springboot.service;



import com.example.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUsers(User user);

    User getById(int id);

    void delete(int id);
}
