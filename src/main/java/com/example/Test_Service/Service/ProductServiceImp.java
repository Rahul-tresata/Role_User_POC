package com.example.Test_Service.Service;

import com.example.Test_Service.Entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImp implements ProductService{
    @Override
    public List<ProductEntity> findallProduct() {
        return null;
    }

    @Override
    public Optional<ProductEntity> findProductById(int id) {
        return Optional.empty();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity user) {
        return null;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity user) {
        return null;
    }

    @Override
    public String deleteProduct(int id) {
        return null;
    }
}
