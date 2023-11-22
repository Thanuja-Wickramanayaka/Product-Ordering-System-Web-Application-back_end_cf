package com.example.back_end_cf.dao;

import com.example.back_end_cf.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDAO extends JpaRepository<Client,Integer> {

    Client findByClientID(Integer clientID);

    Client getByClientID(Integer clientID);


    List<Client> findAllByClientName(String clientName);
}
