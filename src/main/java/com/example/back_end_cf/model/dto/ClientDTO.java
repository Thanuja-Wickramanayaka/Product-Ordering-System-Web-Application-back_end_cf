package com.example.back_end_cf.model.dto;

import com.example.back_end_cf.model.Client;

public class ClientDTO {

    private Integer clientID;
    private String clientName;
    private String clientAddress;
    private String clientMobile;
    private String clientEmail;
    private String clientStatus;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        this.clientID = client.getClientID();
        this.clientName = client.getClientName();
        this.clientAddress = client.getClientAddress();
        this.clientMobile = client.getClientMobile();
        this.clientEmail = client.getClientEmail();
        this.clientStatus = client.getClientStatus();
    }


    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }
}
