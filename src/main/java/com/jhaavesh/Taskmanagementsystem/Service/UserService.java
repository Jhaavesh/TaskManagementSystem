package com.jhaavesh.Taskmanagementsystem.Service;

import com.jhaavesh.Taskmanagementsystem.Model.User;

import java.util.List;

public interface UserService {

    User getUserByEmail(String email);
    User saveUser(User user);
    User getUserById(Long id);



    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);

}
