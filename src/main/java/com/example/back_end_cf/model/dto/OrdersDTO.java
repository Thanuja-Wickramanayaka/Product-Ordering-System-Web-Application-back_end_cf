package com.example.back_end_cf.model.dto;

import com.example.back_end_cf.model.Orders;

public class OrdersDTO {


    private Integer orderID;
    private String  billNumber;
    private String  billedDate;

    private Integer clientID;
    private String clientName;

    private Integer productID;
    private String productCode;
    private String productName;

    private Integer orderQuantity;
    private Integer totalAMount;
    private String paymentMethod;
    private String paymentStatus;

    public OrdersDTO() {
    }

    public OrdersDTO(Orders orders) {
        this.orderID = orders.getOrderID();
        this.billNumber = orders.getBillNumber();
        this.billedDate = orders.getBilledDate();

        if(orders.getClient() !=null){
            this.clientID = orders.getClient().getClientID();
            this.clientName = orders.getClient().getClientName();
        }

        if (orders.getProduct() !=null){
            this.productID = orders.getProduct().getProductID();
            this.productCode = orders.getProduct().getProductCode();
            this.productName = orders.getProduct().getProductName();
        }

        this.orderQuantity = orders.getOrderQuantity();
        this.totalAMount = orders.getTotalAMount();
        this.paymentMethod = orders.getPaymentMethod();
        this.paymentStatus = orders.getPaymentStatus();
    }


    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getBilledDate() {
        return billedDate;
    }

    public void setBilledDate(String billedDate) {
        this.billedDate = billedDate;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getTotalAMount() {
        return totalAMount;
    }

    public void setTotalAMount(Integer totalAMount) {
        this.totalAMount = totalAMount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
