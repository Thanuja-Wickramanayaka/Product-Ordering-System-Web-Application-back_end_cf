package com.example.back_end_cf.service;


import com.example.back_end_cf.dao.ClientDAO;
import com.example.back_end_cf.model.Client;
import com.example.back_end_cf.model.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

//GET ALL
    public List<ClientDTO> getAllClients (){
        List<Client> clientList = clientDAO.findAll();

        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client client: clientList){
            ClientDTO clientDTO = new ClientDTO(client);
            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }

//SAVE
    public Client saveClient (Client client){
        Client addclient = this.clientDAO.saveAndFlush(client);
        return addclient;
    }


//SAVE AND UPDATE

    public ClientDTO saveAndUpdateClient (ClientDTO clientDTO){
        Client existingClient = null;

        if (clientDTO.getClientID()!= null){
            existingClient = clientDAO.getReferenceById(clientDTO.getClientID());
        }else{
            existingClient = new Client();
        }
        existingClient.setClientName(clientDTO.getClientName());
        existingClient.setClientAddress(clientDTO.getClientAddress());
        existingClient.setClientMobile(clientDTO.getClientMobile());
        existingClient.setClientEmail(clientDTO.getClientEmail());
        existingClient.setClientStatus(clientDTO.getClientStatus());

        this.clientDAO.saveAndFlush(existingClient);
        return new ClientDTO(existingClient);
    }


//SEARCH CLIENT BY ID
    public ClientDTO searchClient (Integer clientID){
        Client client =  this.clientDAO.findByClientID(clientID);
        return new ClientDTO(client);
    }


//GET CLIENT BY NAME
    public List<ClientDTO> getClientByName (String clientName){
        List<Client> clientList = clientDAO.findAllByClientName(clientName);
        List<ClientDTO> clientDTOList = new ArrayList<>();
        for (Client client:clientList){
            ClientDTO clientDTO = new ClientDTO(client);

            clientDTOList.add(clientDTO);
        }
        return clientDTOList;
    }


//DELETE CLIENT
    public boolean deleteClientByID(Integer clientID) {
        Client existingClient =clientDAO.getByClientID(clientID);
        if (existingClient != null) {
            clientDAO.deleteById(clientID);
            return true;
        }
        return false;

    }

}















