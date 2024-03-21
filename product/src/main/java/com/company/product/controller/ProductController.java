package com.company.product.controller;


import com.company.product.model.ProductListResponse;
import com.company.product.model.ProductModel;
import com.company.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/getProduct")
    public ResponseEntity<ProductListResponse> getAllProducts(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "25") int limit) {

            return productService.getAllProducts(offset,limit);
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
