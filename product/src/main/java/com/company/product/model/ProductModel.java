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
    @Setter
    @Id
    private Long id;
    private String service;
    @Setter
    private int netprice;
    @Setter
    private int mrp;
    private LocalDateTime created;

    @PrePersist
    public void prePersist() {
        this.created = LocalDateTime.now();
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public String getService() {
        return service;
    }

    public int getNetprice() {
        return netprice;
    }

    public int getMrp() {
        return mrp;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
