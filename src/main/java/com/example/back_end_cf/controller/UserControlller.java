package com.example.back_end_cf.controller;

import com.example.back_end_cf.dto.LoginRQDTO;
import com.example.back_end_cf.model.User;
import com.example.back_end_cf.model.dto.UserDTO;
import com.example.back_end_cf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControlller {

    @Autowired
    private UserService userService;

    //USER LOGIN
    @RequestMapping(value = "/get-logged-user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> getLogUser(@RequestBody LoginRQDTO loginRQDTO) {
        UserDTO userDTO = this.userService.loggedUser(loginRQDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }


    //GET ALL USERS
    @RequestMapping(value = "/get-all-users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = this.userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

}
