package com.Service;
import java.util.List;

import com.entities.User;

public interface IUserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);
    User deleteUserById(int id);
    User updateUser(int id ,User user);
} 
