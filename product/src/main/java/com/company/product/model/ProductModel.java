package com.company.product.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="product")
public class ProductModel {
    @Id
    private Long id;
    private String name;

}
