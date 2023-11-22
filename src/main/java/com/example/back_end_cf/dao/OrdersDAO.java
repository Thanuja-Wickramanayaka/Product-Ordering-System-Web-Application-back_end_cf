package com.example.back_end_cf.dao;


import com.example.back_end_cf.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDAO extends JpaRepository <Orders, Integer>{

    Orders getOrderByOrderID(Integer orderID);

    Orders getByOrderID(Integer orderID);

    List<Orders> findAllByBillNumber(String billNumber);
}
