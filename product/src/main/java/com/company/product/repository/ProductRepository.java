package com.company.product.repository;


import com.company.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Long> {

}
