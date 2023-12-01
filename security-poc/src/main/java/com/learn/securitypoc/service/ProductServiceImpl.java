package com.learn.securitypoc.service;

import com.learn.securitypoc.dto.Product;
import com.learn.securitypoc.entity.UserEntity;
import com.learn.securitypoc.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{

    private List<Product> productList;

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostConstruct
    void loadProductData() {
        productList = IntStream.rangeClosed(1,100)
                .mapToObj( i -> Product
                        .builder()
                        .productId(i)
                        .productName("product-"+ i)
                        .quantity(new Random().nextInt(10))
                        .price(new Random().nextDouble()).build()).collect(Collectors.toList());
    }
    @Override
    public Product getProduct(Integer productId) {
        return productList.stream()
                .filter(product -> product.getProductId() == productId)
                .findAny().orElseThrow(() -> new RuntimeException(String.format("Could not found product with %i", productId)));
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    public String addUser(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));;
        log.info("User password after encrypt {}", user.getPassword());
        repository.save(user);
        return String.format("user saved with ID: %s", user.getUserId());
    }
}
