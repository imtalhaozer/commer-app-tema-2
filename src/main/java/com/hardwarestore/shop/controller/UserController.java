package com.hardwarestore.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hardwarestore.shop.entity.User;
import com.hardwarestore.shop.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getOneUserbyId(@PathVariable Long userId){
        return userService.getOneUserbyId(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
            userService.deleteOneUser(userId);
    }
    
}
