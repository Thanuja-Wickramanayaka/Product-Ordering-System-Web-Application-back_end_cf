package com.example.back_end_cf.service;

import com.example.back_end_cf.model.Orders;
import com.example.back_end_cf.model.dto.OrdersDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrdersServiceTest {
    @Autowired
    private OrdersService ordersService;

    @Test
    void getAllOrders() {
        this.ordersService.getAllOrders();
    }

    @Test
    void searchOrder() {
        this.ordersService.searchOrder(1);
    }

    @Test
    void deleteOrdersByID() {
        this.ordersService.deleteOrdersByID(2);
    }

 /*   @Test
    void getOrderByBillNumber() {
        this.ordersService.getOrderByBillNumber("CF-001");
    } */

//    @Test
//    void saveOrder() {
//        OrdersDTO ordersDTO = new OrdersDTO();
//
//        ordersDTO.setBillNumber("CF-002");
//        ordersDTO.setBilledDate("2023-03-28");
//        ordersDTO.setOrderID(2);
//        ordersDTO.setProductID(4);
//        ordersDTO.setOrderQuantity(50);
//        ordersDTO.setTotalAMount(100000);
//        ordersDTO.setPaymentMethod("Cash");
//        ordersDTO.setPaymentStatus("Payment Received");
//
//        ordersService.saveOrder(ordersDTO);
//
//
//
//    }


//    @Test
//    void saveAndUpdateOrders() {
//        OrdersDTO ordersDTO = new OrdersDTO();
//        ordersDTO.setOrderID(2);
//        ordersDTO.setBillNumber("CF-002");
//        ordersDTO.setBilledDate("2023-03-26");
//        ordersDTO.setClientID(1);
//        ordersDTO.setProductID(4);
//        ordersDTO.setOrderQuantity(100);
//        ordersDTO.setTotalAMount(100000);
//        ordersDTO.setPaymentMethod("Cheque");
//        ordersDTO.setPaymentStatus("Payment Not Received");
//
//        this.ordersService.saveAndUpdateOrders(ordersDTO);
//
//
//    }

}
