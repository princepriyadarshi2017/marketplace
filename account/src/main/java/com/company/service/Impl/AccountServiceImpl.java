package com.company.service.Impl;


import com.company.constant.AccountConstant;
import com.company.dto.CustomerDto;
import com.company.entity.AccountEntity;
import com.company.entity.CustomerEntity;
import com.company.exception.CustomerAlreadyExistsException;
import com.company.mapper.CustomerMapper;
import com.company.repository.AccountRepository;
import com.company.repository.CustomerRepository;
import com.company.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {

        CustomerEntity customerEntity = CustomerMapper.mapToCustomerEntity(customerDto,new CustomerEntity());
        Optional<CustomerEntity> optionalCustomerEntity =customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomerEntity.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already registered"+customerDto.getMobileNumber());
        }
            CustomerEntity savedCustomer=customerRepository.save(customerEntity);
            accountRepository.save(createNewAccount(savedCustomer));


    }

    private AccountEntity createNewAccount(CustomerEntity customerEntity) {

        AccountEntity newAccountEntity =new AccountEntity();
        newAccountEntity.setCustomerId(customerEntity.getCustomerId());
        long randomAccNumber =1000000L+ new Random().nextInt(900000000);
        newAccountEntity.setAccountNumber(randomAccNumber);
        newAccountEntity.setBranchAddress(AccountConstant.ADDRESS);
        newAccountEntity.setAccountType(AccountConstant.SAVINGS);
        return newAccountEntity;
    }
}
