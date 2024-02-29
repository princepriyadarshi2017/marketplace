package com.company.product.model;


import lombok.Data;

import java.util.List;

@Data
public class ProductListResponse {
    private List<ProductModel> products;
    private String next;
}
