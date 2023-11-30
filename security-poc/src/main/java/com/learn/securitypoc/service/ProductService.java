package com.learn.securitypoc.service;

import com.learn.securitypoc.dto.Product;
import com.learn.securitypoc.entity.UserEntity;

import java.util.List;

public interface ProductService {
    Product getProduct(Integer productId);

    List<Product> getAllProducts();

    String addUser(UserEntity user);

}
