package com.company.product.repository;


import com.company.product.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;



public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Page<ProductModel> findAll(Pageable pageable);
}

