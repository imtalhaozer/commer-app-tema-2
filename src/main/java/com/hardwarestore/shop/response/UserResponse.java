package com.hardwarestore.shop.response;

import com.hardwarestore.shop.entity.User;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String userName;
    private String userMail;

    public UserResponse(User user){
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.userMail=user.getUserMail();
    }
}
