package com.example.back_end_cf.model.dto;

import com.example.back_end_cf.model.User;

public class UserDTO {

    private  Integer userID;
    private  String userName;
    private  String userPassword;
    private  String userStatus;


    public UserDTO() {
    }

    public UserDTO(User user) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.userPassword = user.getUserPassword();
        this.userStatus = user.getUserStatus();
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
