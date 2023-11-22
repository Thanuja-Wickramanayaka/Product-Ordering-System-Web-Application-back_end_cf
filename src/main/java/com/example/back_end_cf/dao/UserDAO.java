package com.example.back_end_cf.dao;

import com.example.back_end_cf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User , Integer> {
   User findByUserNameAndUserPassword(String userName , String password);
}
