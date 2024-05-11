package com.hardwarestore.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hardwarestore.shop.entity.User;
import com.hardwarestore.shop.repository.UserRepository;

@Service
public class UserService {

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
        }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserbyId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user=userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser=user.get();
            foundUser.setUserAddress(newUser.getUserAddress());
            foundUser.setUserMail(newUser.getUserMail());
            foundUser.setUserName(newUser.getUserName());
            foundUser.setUserNumber(newUser.getUserNumber());
            foundUser.setUserPassword(newUser.getUserPassword());
            userRepository.save(foundUser);
            return newUser;
        }
        else
        return null;
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
        System.out.println("successfully deleted");
    }
    
}
