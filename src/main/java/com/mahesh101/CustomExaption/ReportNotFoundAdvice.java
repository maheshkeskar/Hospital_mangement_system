package com.mahesh101.CustomExaption;
;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ReportNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ReportNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String patientNotFoundHandler(ReportNotFoundException ex) {
        return ex.getMessage();
    }

}
