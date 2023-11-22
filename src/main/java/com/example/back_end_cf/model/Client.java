package com.example.back_end_cf.model;

import javax.persistence.*;

@Entity
@Table(name = "client_table")
public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "CLIENT_ID ")
    private Integer clientID;

    @Column (name = "CLIENT_NAME")
    private String clientName;

    @Column (name = "CLIENT_ADDRESS")
    private String clientAddress;

    @Column (name = "CLIENT_MOBILE")
    private String clientMobile;

    @Column (name = "CLIENT_EMAIL")
    private String clientEmail;

    @Column (name = "CLIENT_STATUS")
    private String clientStatus;

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
