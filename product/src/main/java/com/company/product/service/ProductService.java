package com.company.product.service;


import com.company.product.Product;
import com.company.product.model.ProductListResponse;
import com.company.product.model.ProductModel;
import com.company.product.repository.ProductRepository;
import jakarta.transaction.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public ProductModel createProduct(ProductModel productModel) {
        try {
            return productRepository.save(productModel);
        }
//        catch (SystemException e) {
//            // Handle SystemException
//            log.error("SystemException creating product: {}", e.getMessage());
//            throw new RuntimeException("Failed to create product", e);
//        }
//        catch (IOException e) {
//            // Handle IOException
//            log.error("IOException creating product: {}", e.getMessage());
//            throw new RuntimeException("Failed to create product", e);
//        }
        catch (Exception e) {
            // Handle other exceptions
            log.error("Error creating product: {}", e.getMessage());
            throw new RuntimeException("Failed to create product", e);
        }
    }

    public ResponseEntity<ProductModel> updateProduct(Long id,ProductModel productModel  ){
try {
        Optional<ProductModel> existingProduct = productRepository.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productModel.setId(id);
        productRepository.save(productModel);
        return ResponseEntity.ok(productModel);
    } catch (Exception e) {
    log.error("Error updating product: {} ",e.getMessage());
    throw new RuntimeException("Failed to update product",e);
}
    }

    public ResponseEntity<Void> deleteProduct(Long id ){

        try{
            Optional<ProductModel> existingProduct = productRepository.findById(id);
            if (!existingProduct.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            productRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e ){
            log.error("Error in deleting product",e.getMessage());
            throw new RuntimeException("Failed to delete ",e);
        }

    }

    public List<ProductModel> getFirst25Products() {
        return productRepository.findAll(PageRequest.of(0, 25)).getContent();
    }

    public int getTotalProductsCount() {
        return (int) productRepository.count();
    }

    public ResponseEntity<ProductListResponse> getAllProducts() {
        List<ProductModel> list = getFirst25Products();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            int totalRecords = getTotalProductsCount();
            int remainingRecords = totalRecords - list.size();
            String nextLink = null;
            if (remainingRecords > 0) {
                nextLink = "/api/products?offset=" + (totalRecords - remainingRecords);
            }
            ProductListResponse response = new ProductListResponse();
            response.setProducts(list);
            response.setNext(nextLink);
            return ResponseEntity.ok(response);
        }
    }


}
