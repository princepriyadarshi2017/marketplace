package com.company.mapper;

import com.company.dto.AccountDto;
import com.company.entity.AccountEntity;

public class AccountMapper {

    public static AccountDto mapToAccountDto(AccountEntity accountEntity, AccountDto accountDto) {
        accountDto.setAccountNumber(accountEntity.getAccountNumber());
        accountDto.setAccountType(accountEntity.getAccountType());
        accountDto.setBranchAddress(accountEntity.getBranchAddress());
        return accountDto;
    }

    public static AccountEntity mapToAccountEntity(AccountDto accountDto,AccountEntity accountEntity){
        accountEntity.setAccountNumber(accountDto.getAccountNumber());
        accountEntity.setAccountType(accountDto.getAccountType());
        accountEntity.setBranchAddress(accountDto.getBranchAddress());

        return accountEntity;
    }
}
