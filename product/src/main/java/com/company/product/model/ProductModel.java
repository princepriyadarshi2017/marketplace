package com.company.product.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="product")
public class ProductModel {
    @Id
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
