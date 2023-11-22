package com.example.back_end_cf.controller;


import com.example.back_end_cf.model.dto.OrdersDTO;
import com.example.back_end_cf.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    //GET ALL ORDERS
    @RequestMapping(value = "/get-All-Orders", method = RequestMethod.GET)
    public ResponseEntity<List<OrdersDTO>> getAllOrders() {
        List<OrdersDTO> ordersList = this.ordersService.getAllOrders();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }


////JDBC
//    @RequestMapping (value = "/get-All-Orders-With-Search" , method = RequestMethod.GET)
//    public ResponseEntity<List <OrdersDTO>>getAllOrdersWithSearch(){
//        List<OrdersDTO> orders = this.ordersService.getAllOrdersWithSearch();
//        return new ResponseEntity<>(orders , HttpStatus.OK);
//    }


    //SEARCH ORDERS BY ID
    @RequestMapping(value = "/search-orders/{orderID}", method = RequestMethod.GET)
    public ResponseEntity<OrdersDTO> searchOrders(@PathVariable Integer orderID) {
        OrdersDTO ordersDTO = this.ordersService.searchOrder(orderID);
        return new ResponseEntity<>(ordersDTO, HttpStatus.OK);
    }


    //SAVE-UPDATE ORDERS
    @RequestMapping(value = "/save-orders", method = RequestMethod.POST)
    public ResponseEntity<OrdersDTO> saveOrder(@RequestBody OrdersDTO ordersDTO) {
        OrdersDTO newOrders = this.ordersService.saveOrder(ordersDTO);
        return new ResponseEntity<>(newOrders, HttpStatus.CREATED);
    }


    //GET ORDERS BY BILL NUMBER
    @RequestMapping(value = "/get-orders-by-bill-number/{billNumber}", method = RequestMethod.GET)
    public ResponseEntity<List<OrdersDTO>> getOrdersByBillNumber(@PathVariable String billNumber) {
        List<OrdersDTO> ordersDTOList = this.ordersService.getOrderByBillNumber(billNumber);
        return new ResponseEntity<>(ordersDTOList, HttpStatus.OK);
    }


    //DELETE ORDERS
    @RequestMapping(value = "/delete-orders/{orderID}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteOrdersByID(@PathVariable Integer orderID) {
        Boolean result = this.ordersService.deleteOrdersByID(orderID);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


////UPDATE ORDERS
//    @RequestMapping(value = "/update-orders"  , method = RequestMethod.PUT)
//    public ResponseEntity<OrdersDTO> updateOrder  (@RequestBody OrdersDTO ordersDTO){
//        OrdersDTO existingOrder = this.ordersService.updateOrder (ordersDTO);
//        return new ResponseEntity<>(existingOrder,HttpStatus.CREATED);
//    }


////SAVE AND UPDATE ORDERS
//    @RequestMapping(value = "/save-and-update-orders"  , method = RequestMethod.POST)
//    public ResponseEntity<OrdersDTO> saveAndUpdateOrders (@RequestBody OrdersDTO ordersDTO){
//        OrdersDTO newOrders = this.ordersService.saveAndUpdateOrders(ordersDTO);
//        return new ResponseEntity<>(newOrders,HttpStatus.OK);
//    }


}
