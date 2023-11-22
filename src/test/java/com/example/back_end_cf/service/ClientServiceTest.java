package com.example.back_end_cf.service;

import com.example.back_end_cf.model.Client;
import com.example.back_end_cf.model.dto.ClientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Test
    void getAllClients() {
        this.clientService.getAllClients();
    }

    @Test
    void saveClient() {
        Client client = new Client();

        client.setClientName("Sampath");
        client.setClientAddress("Kaluthara");
        client.setClientMobile("0715474856");
        client.setClientEmail("sampath@gmail.com");
        client.setClientStatus("Available");

        clientService.saveClient(client);

    }

    @Test
    void saveAndUpdateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientID(02);
        clientDTO.setClientName("Janaka");
        clientDTO.setClientAddress("Matale");
        clientDTO.setClientMobile("0745748965");
        clientDTO.setClientEmail("janaka@gmail.com");
        clientDTO.setClientStatus("Available");

        this.clientService.saveAndUpdateClient(clientDTO);
    }


    @Test
    void searchClient() {this.clientService.searchClient(2);
    }

    @Test
    void deleteClientByID() {this.clientService.deleteClientByID(4);
    }

    @Test
    void getClientByName() {this.clientService.getClientByName("User");
    }
}
