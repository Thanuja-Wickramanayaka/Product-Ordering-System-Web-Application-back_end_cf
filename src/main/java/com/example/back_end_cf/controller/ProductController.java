package com.example.back_end_cf.controller;

import com.example.back_end_cf.model.dto.ProductDTO;
import com.example.back_end_cf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //GET All PRODUCTS
    @RequestMapping(value = "/get-all-products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> productList = this.productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }


    //SAVE AND UPDATE PRODUCTS
    @RequestMapping(value = "/save-and-update-product", method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> saveAndUpdateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO newProduct = this.productService.saveAndUpdateProduct(productDTO);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }


    //SEARCH PRODUCTS BY ID
    @RequestMapping(value = "/search-product/{productID}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> searchProduct(@PathVariable Integer productID) {
        ProductDTO productDTO = this.productService.searchProduct(productID);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }


    //GET PRODUCTS BY PRODUCTS CODE
    @RequestMapping(value = "/get-product-by-product-code/{productCode}", method = RequestMethod.POST)
    public ResponseEntity<List<ProductDTO>> getProductByProductCode(@PathVariable String productCode) {
        List<ProductDTO> productDTOList = this.productService.getProuctByProductCode(productCode);
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }


    //GET PRODUCTS BY PRODUCTS NAME
    @RequestMapping(value = "/get-product-by-name/{productName}", method = RequestMethod.POST)
    public ResponseEntity<List<ProductDTO>> getProductByName(@PathVariable String productName) {
        List<ProductDTO> productDTOList = this.productService.getProuctByName(productName);
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }


    //DELETE PRODUCTS
    @RequestMapping(value = "/delete-product/{productID}", method = RequestMethod.DELETE)
    public boolean deleteClientByID(@PathVariable Integer productID) {
        return productService.deleteProductByID(productID);
    }
}
