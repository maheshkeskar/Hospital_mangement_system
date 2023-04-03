package com.mahesh101.CustomExaption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class patientNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(patientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String RestaurantNotFoundHandler(patientNotFoundException ex){
        return ex.getMessage();
    }
}

