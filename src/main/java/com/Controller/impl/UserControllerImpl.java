package com.Controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Controller.IUserController;
import com.Service.impl.UserServiceImpl;
import com.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/rest/api")
public class UserControllerImpl  implements IUserController{
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add-user")
    @Override
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
