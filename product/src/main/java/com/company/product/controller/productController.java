package com.company.product.controller;


import com.company.product.model.ProductModel;
import com.company.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getProduct")
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/createProduct")
    public ProductModel createProduct(@RequestBody ProductModel productModel) {
        return productRepository.save(productModel);
    }
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel) {
        Optional<ProductModel> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productModel.setId(id);
        productRepository.save(productModel);
        return ResponseEntity.ok(productModel);
    }


    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<ProductModel> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
