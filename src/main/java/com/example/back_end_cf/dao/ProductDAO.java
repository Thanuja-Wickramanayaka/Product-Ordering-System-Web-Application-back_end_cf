package com.example.back_end_cf.dao;

import com.example.back_end_cf.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {

    Product findByProductID(Integer productID);

    List<Product> findAllByProductName(String productName);

    Product getByProductID(Integer productID);

    List<Product> findAllByProductCode(String productCode);
}
