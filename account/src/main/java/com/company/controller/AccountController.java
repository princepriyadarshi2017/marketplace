package com.company.controller;


import com.company.constant.AccountConstant;
import com.company.dto.CustomerDto;
import com.company.dto.ResponseDto;
import com.company.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1")
@AllArgsConstructor
public class AccountController {

    private IAccountService iAccountService;

    @GetMapping("/createAccount")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

        iAccountService.createAccount(customerDto); //this exception throwing


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstant.STATUS_201,AccountConstant.MESSAGE_200));
    }
}
