package com.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.UserRepository;
import com.Service.IUserService;
import com.entities.User;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User getUserById(int id) {
        Optional<User> optional = userRepository.findById(id);
        if(!optional.isEmpty()){
            return optional.get();
        }
        return null;
    }
    @Override
    public User deleteUserById(int id ){
        User dbUser = getUserById(id);
        if(dbUser != null){
            User deletedUser = new User();
            deletedUser.setId(dbUser.getId());
            deletedUser.setUsername(dbUser.getUsername());
            deletedUser.setPassword(dbUser.getPassword());
            userRepository.delete(dbUser);
            return deletedUser;

        }
        return null;
    }
    @Override
    public User updateUser(int id, User user) {
        User dbUser = getUserById(id);
        if(dbUser != null){
            dbUser.setUsername(user.getUsername());
            dbUser.setPassword(user.getPassword());
            return userRepository.save(dbUser);
        }
        return null;
    }
    
}
