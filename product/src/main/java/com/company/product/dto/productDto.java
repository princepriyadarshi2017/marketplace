package com.company.product.dto;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class productDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String service;
    private int netprice;
    private int mrp;
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }
}
