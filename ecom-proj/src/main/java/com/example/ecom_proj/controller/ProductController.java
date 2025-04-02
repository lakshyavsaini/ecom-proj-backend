package com.example.ecom_proj.controller;


import com.example.ecom_proj.model.Product;
import com.example.ecom_proj.repo.ProductRepo;
import com.example.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    @Autowired
    private ProductService service;


    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return service.getAllProducts();

    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct( @RequestPart Product product,
                                            @RequestPart MultipartFile imageFile  ){
        System.out.println(product);
        try {
            Product product1= service.addProduct(product, imageFile);
            return new  ResponseEntity<>(product1,HttpStatus.OK );

        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


}
