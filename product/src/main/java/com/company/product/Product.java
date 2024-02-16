package com.company.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Product {

    public static void main(String[] args) {

        SpringApplication.run(Product.class, args);
        log.info("Product application is started");
    }

}