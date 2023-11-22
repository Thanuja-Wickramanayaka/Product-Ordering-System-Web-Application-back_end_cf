package com.example.back_end_cf.model;

import javax.persistence.*;

@Entity
@Table(name = "orders_table")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID ")
    private Integer orderID;

    @Column(name = "BILL_NUMBER")
    private String  billNumber;

    @Column(name = "BILLED_DATE")
    private String billedDate;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CLIENT_ID ")
    private Client client;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRODUCT_ID ")
    private Product product;

    @Column(name = "ORDER_QUANTITY")
    private Integer orderQuantity;

    @Column(name = "TOTAL_AMOUNT")
    private Integer totalAMount;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;

    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;


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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}
