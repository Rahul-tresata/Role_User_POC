package com.example.Test_Service.Service;

import com.example.Test_Service.Entity.ProductEntity;
import com.example.Test_Service.Entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductEntity> findallProduct();
    Optional<ProductEntity> findProductById(int id);
    ProductEntity saveProduct(ProductEntity user);
    ProductEntity updateProduct(ProductEntity user);
    String deleteProduct(int id);
}
