package com.Controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Controller.IUserController;
import com.Service.impl.UserServiceImpl;
import com.entities.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl  implements IUserController{
    
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    @Override
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    @Override
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/byId/{id}")
    @Override
    public User getUserById(@PathVariable(name="id")int id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public User deleteUserById(@PathVariable(name="id")int id){
        return userService.deleteUserById(id);
    }

    @PutMapping("/update/{id}")
    public User updateUserById(@PathVariable(name="id") int id,@RequestBody User user ){
        return userService.updateUser(id,user);
    }
}
