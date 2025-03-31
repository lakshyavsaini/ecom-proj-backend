package com.example.ecom_proj.controller;


import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepo;
import com.example.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public List<ProductRepo> getAllProducts(){
        return service.getAllProducts();

    }
}
