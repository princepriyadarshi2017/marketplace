package com.company.repository;

import com.company.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository <CustomerEntity,Long> {

    Optional<CustomerEntity> findByMobileNumber(String mobileNumber);
}
