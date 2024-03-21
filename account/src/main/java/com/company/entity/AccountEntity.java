package com.company.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;


@Table(name="customer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {


    private Long customerId;

    private Long accountNumber;
    private String accountType;
    private String branchAddress;

}


