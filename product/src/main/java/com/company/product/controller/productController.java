package com.company.product.controller;


import com.company.product.model.ProductModel;
import com.company.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProduct")
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }


}
