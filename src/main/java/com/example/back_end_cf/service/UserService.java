package com.example.back_end_cf.service;

import com.example.back_end_cf.dao.UserDAO;
import com.example.back_end_cf.dto.LoginRQDTO;
import com.example.back_end_cf.model.User;
import com.example.back_end_cf.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    //GET LOGIN
    public UserDTO loggedUser (LoginRQDTO loginRQDTO){
        User user = this.userDAO.findByUserNameAndUserPassword(loginRQDTO.getUserName(),loginRQDTO.getUserPassword());
        UserDTO userDTO = null;
        if(user!=null){
            userDTO = new UserDTO(user);
        }
        return userDTO;
    }


    //GET ALL
    public List<UserDTO> getAllUsers (){
        List<User> userList = this.userDAO.findAll();

        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList){
            UserDTO userDTO = new UserDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }



}
