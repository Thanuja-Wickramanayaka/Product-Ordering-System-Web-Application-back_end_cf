package com.example.back_end_cf.service;


import com.example.back_end_cf.dao.ClientDAO;
import com.example.back_end_cf.dao.OrdersDAO;
import com.example.back_end_cf.dao.ProductDAO;
import com.example.back_end_cf.dao.jdbc.OrdersJDBCDao;
import com.example.back_end_cf.model.Client;
import com.example.back_end_cf.model.Orders;
import com.example.back_end_cf.model.Product;
import com.example.back_end_cf.model.dto.OrdersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private OrdersJDBCDao ordersJDBCDao;


//GET ALL
    public List<OrdersDTO> getAllOrders (){
        List<Orders> ordersList = this.ordersDAO.findAll();

        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        for (Orders orders : ordersList){
            OrdersDTO ordersDTO = new OrdersDTO(orders);
            ordersDTOList.add(ordersDTO);
        }
        return ordersDTOList;
    }
//
////JDBC
//    public List<OrdersDTO> getAllOrdersWithSearch(){
//        List<OrdersDTO> ordersDTOS = this.ordersJDBCDao.getAllOrdersWithSearch();
//        return ordersDTOS;
//    }

//SEARCH ORDER BY ID
    public OrdersDTO searchOrder (Integer orderID){
        Orders orders = this.ordersDAO.getOrderByOrderID(orderID);
        return  new OrdersDTO(orders);
    }


//SEARCH ORDER BY BILL NUMBER
public List<OrdersDTO> getOrderByBillNumber (String billNumber){
    List<Orders> ordersList = ordersDAO.findAllByBillNumber(billNumber);
    List<OrdersDTO> ordersDTOList = new ArrayList<>();
    for (Orders orders:ordersList){
        OrdersDTO ordersDTO = new OrdersDTO(orders);
        ordersDTOList.add(ordersDTO);
        }
        return ordersDTOList;
    }

//SAVE-UPDATE ORDER
    public OrdersDTO saveOrder (OrdersDTO ordersDTO){
        Orders orders = null;
        if (ordersDTO.getOrderID() != null){
            orders = this.ordersDAO.getById(ordersDTO.getOrderID());

        }else{
            orders = new Orders();
        }


        orders.setBillNumber(ordersDTO.getBillNumber());
        orders.setBilledDate(ordersDTO.getBilledDate());
        orders.setClient(this.clientDAO.getReferenceById(ordersDTO.getClientID()));
        orders.setProduct(this.productDAO.getReferenceById(ordersDTO.getProductID()));
        orders.setOrderQuantity(ordersDTO.getOrderQuantity());
        orders.setTotalAMount(ordersDTO.getTotalAMount());
        orders.setPaymentMethod(ordersDTO.getPaymentMethod());
        orders.setPaymentStatus(ordersDTO.getPaymentStatus());

        orders = this.ordersDAO.saveAndFlush(orders);
        return new OrdersDTO(orders);
    }

//
////UPDATE
//    public OrdersDTO updateOrder (OrdersDTO ordersDTO) {
//        Orders existingOrder = null;
//
//        if (ordersDTO.getOrderID() != null) {
//            existingOrder = ordersDAO.getOrderByOrderID(ordersDTO.getOrderID());
//        } else {
//            existingOrder = new Orders();
//
//        }
//
//        Client client = clientDAO.findByClientID(ordersDTO.getClientID());
//        Product product = productDAO.findByProductID(ordersDTO.getProductID());
//
//        existingOrder.setClient(client);
//        existingOrder.setProduct(product);
//        existingOrder.setOrderID(ordersDTO.getOrderID());
//        existingOrder.setBillNumber(ordersDTO.getBillNumber());
//        existingOrder.setBilledDate(ordersDTO.getBilledDate());
//        existingOrder.setOrderQuantity(ordersDTO.getOrderQuantity());
//        existingOrder.setTotalAMount(ordersDTO.getTotalAMount());
//        existingOrder.setPaymentMethod(ordersDTO.getPaymentMethod());
//        existingOrder.setPaymentStatus(ordersDTO.getPaymentStatus());
//
//        existingOrder = ordersDAO.saveAndFlush(existingOrder);
//        return new OrdersDTO(existingOrder);
//
//    }



//
////SAVE AND UPDATE
//    public OrdersDTO saveAndUpdateOrders (OrdersDTO ordersDTO){
//        Orders existingOrders = null;
//        if (ordersDTO.getOrderID()!= null){
//            existingOrders = ordersDAO.getReferenceById(ordersDTO.getOrderID());
//        }else{
//            existingOrders = new Orders();
//        }
//        Client client = clientDAO.getReferenceById(ordersDTO.getClientID());
//        Product product = productDAO.getReferenceById(ordersDTO.getProductID());
//
//        existingOrders.setBillNumber(ordersDTO.getBillNumber());
//        existingOrders.setBilledDate(ordersDTO.getBilledDate());
//        existingOrders.setClient(client);
//        existingOrders.setProduct(product);
//        existingOrders.setOrderQuantity(ordersDTO.getOrderQuantity());
//        existingOrders.setTotalAMount(ordersDTO.getTotalAMount());
//        existingOrders.setPaymentMethod(ordersDTO.getPaymentMethod());
//        existingOrders.setPaymentStatus(ordersDTO.getPaymentStatus());
//
//        existingOrders = ordersDAO.saveAndFlush(existingOrders);
//        return new OrdersDTO(existingOrders);
//    }
//

//DELETE ORDERS
    public boolean deleteOrdersByID (Integer orderID){
        Orders exisitngOrders = ordersDAO.getByOrderID(orderID);
        if (exisitngOrders != null){
            ordersDAO.deleteById(orderID);
            return true;
        }
        return false;
    }


}
