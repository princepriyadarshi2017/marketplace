package com.company.mapper;

import com.company.dto.CustomerDto;
import com.company.entity.CustomerEntity;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(CustomerDto customerDto,CustomerEntity customerEntity){

        customerDto.setEmail(customerEntity.getEmail());
        customerDto.setName(customerEntity.getName());
        customerDto.setMobileNumber(customerEntity.getMobileNumber());
        return customerDto;
    }

    public static CustomerEntity mapToCustomerEntity(CustomerDto customerDto,CustomerEntity customerEntity){
        customerEntity.setMobileNumber(customerDto.getMobileNumber());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setName(customerDto.getName());
        return customerEntity;
    }

}
