package com.example.back_end_cf.service;

import com.example.back_end_cf.dao.ProductDAO;
import com.example.back_end_cf.model.Product;
import com.example.back_end_cf.model.dto.ClientDTO;
import com.example.back_end_cf.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDAO productDAO;


//GET ALL
    public List<ProductDTO> getAllProducts (){
        List<Product> productList = productDAO.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList){
            ProductDTO productDTO = new ProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

//SAVE
    public Product saveProduct (Product product){
        Product addProduct =this.productDAO.saveAndFlush(product);
        return addProduct;
    }

//SAVE AND UPDATE
    public ProductDTO saveAndUpdateProduct (ProductDTO productDTO){
        Product existingProduct = null;

       if (productDTO.getProductID()!=null){
           existingProduct = productDAO.getReferenceById(productDTO.getProductID());
       }else{
           existingProduct = new Product();
       }
       existingProduct.setProductCode(productDTO.getProductCode());
       existingProduct.setProductName(productDTO.getProductName());
       existingProduct.setProductSize(productDTO.getProductSize());
       existingProduct.setProductPrice(productDTO.getProductPrice());
       existingProduct.setProductStatus(productDTO.getProductStatus());

       this.productDAO.saveAndFlush(existingProduct);
       return new ProductDTO(existingProduct);
    }


//SEARCH PRODUCT BY ID
    public ProductDTO searchProduct (Integer productID){
        Product product = this.productDAO.findByProductID(productID);
        return  new ProductDTO(product);
    }


//GET PRODUCT BY NAME
    public List<ProductDTO> getProuctByProductCode (String productCode){
        List<Product> productList = productDAO.findAllByProductCode(productCode);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product:productList){
            ProductDTO productDTO = new ProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }




    //GET PRODUCT BY NAME
    public List<ProductDTO> getProuctByName (String productName){
        List<Product> productList = productDAO.findAllByProductName(productName);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product:productList){
            ProductDTO productDTO = new ProductDTO(product);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }





//DELETE PRODUCT
    public boolean deleteProductByID (Integer productID){
        Product existingProduct = productDAO.getByProductID(productID);
        if (existingProduct != null){
            productDAO.deleteById(productID);
            return true;
        }
        return false;

    }

}
