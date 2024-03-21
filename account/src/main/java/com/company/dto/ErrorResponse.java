package com.company.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data @AllArgsConstructor
public class ErrorResponse {


    private String apiPath;

    private HttpStatus error;

    private String errorMessage;

    private LocalDate errorTime;


}
