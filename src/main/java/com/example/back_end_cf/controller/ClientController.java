package com.example.back_end_cf.controller;

import com.example.back_end_cf.model.Client;
import com.example.back_end_cf.model.dto.ClientDTO;
import com.example.back_end_cf.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    //GET All CLIENTS
    @RequestMapping(value = "/get-all-clients", method = RequestMethod.GET)
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clientList = this.clientService.getAllClients();
        return new ResponseEntity<>(clientList, HttpStatus.OK);
    }


    //SAVE AND UPDATE CLIENTS
    @RequestMapping(value = "/save-and-update-client", method = RequestMethod.POST)
    public ResponseEntity<ClientDTO> saveAndUpdateHardware(@RequestBody ClientDTO clientDTO) {
        ClientDTO newClient = this.clientService.saveAndUpdateClient(clientDTO);
        return new ResponseEntity<>(newClient, HttpStatus.OK);
    }


    //SEARCH CLIENTS BY ID
    @RequestMapping(value = "/search-client/{clientID}", method = RequestMethod.GET)
    public ResponseEntity<ClientDTO> searchClient(@PathVariable Integer clientID) {
        ClientDTO clientDTO = this.clientService.searchClient(clientID);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }


    //GET CLIENTS BY CLIENT NAME
    @RequestMapping(value = "/get-client-by-name/{clientName}", method = RequestMethod.POST)
    public ResponseEntity<List<ClientDTO>> getClientByName(@PathVariable String clientName) {
        List<ClientDTO> clientDTOList = this.clientService.getClientByName(clientName);
        return new ResponseEntity<>(clientDTOList, HttpStatus.OK);
    }


    //DELETE CLIENTS
    @RequestMapping(value = "/delete-client/{clientID}", method = RequestMethod.DELETE)
    public boolean deleteClientByID(@PathVariable Integer clientID) {
        return clientService.deleteClientByID(clientID);
    }

}

