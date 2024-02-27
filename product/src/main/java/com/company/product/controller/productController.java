package com.company.product.controller;


import com.company.product.model.ProductModel;
import com.company.product.service.ProductService;
import com.company.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {


    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProduct")
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/createProduct")
    public ProductModel create(@RequestBody ProductModel productModel) {
        return productService.createProduct(productModel);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable Long id, @RequestBody ProductModel productModel) {
        return productService.updateProduct(id,productModel);
    }


    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
