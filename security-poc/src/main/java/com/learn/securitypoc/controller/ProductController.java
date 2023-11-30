package com.learn.securitypoc.controller;

import com.learn.securitypoc.dto.Product;
import com.learn.securitypoc.entity.UserEntity;
import com.learn.securitypoc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private String defaultVersion = "1.0.0";

    private final ProductService productService;

    @GetMapping("/")
    public String status() {
        return String.format("Product service is UP & Running %s", defaultVersion);
    }

    @GetMapping("/{productId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProduct(@PathVariable Integer productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestBody UserEntity user) {
        return productService.addUser(user);
    }

}
