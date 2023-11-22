package com.example.back_end_cf.service;

import com.example.back_end_cf.model.Product;
import com.example.back_end_cf.model.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void getAllProducts() {
        this.productService.getAllProducts();

    }

    @Test
    void saveProduct() {
        Product product = new Product();

        product.setProductCode("VTT-601");
        product.setProductName("Coco Metal");
        product.setProductSize("5 KG");
        product.setProductPrice(1750);
        product.setProductStatus("Not Available");

        productService.saveProduct(product);
    }

    @Test
    void saveAndUpdateProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductID(7);
        productDTO.setProductCode("VTT-601");
        productDTO.setProductName("Coco Premier");
        productDTO.setProductSize("5 KG");
        productDTO.setProductPrice(2000);
        productDTO.setProductStatus("Available");

        this.productService.saveAndUpdateProduct(productDTO);
    }

    @Test
    void searchProduct() {
        this.productService.searchProduct(5);
    }

    @Test
    void getProuctByName() {this.productService.getProuctByName("Coco Premier");
    }

    @Test
    void deleteProductByID() {this.productService.deleteProductByID(6);
    }

    @Test
    void getProuctByProductCode() { this.productService.getProuctByProductCode("VTT-01");
    }
}
