package com.Controller;
import java.util.List;

import com.entities.User;



public interface IUserController {

    public User saveUser(User user);
    public List<User> getAllUsers();
    public User getUserById(int id);
    public User deleteUserById(int id);
    public User updateUserById(int id,User user);
}
