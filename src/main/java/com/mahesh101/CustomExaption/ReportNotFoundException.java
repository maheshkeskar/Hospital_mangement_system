package com.mahesh101.CustomExaption;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException(Long id){
        super(("Could not find restaurant"+id));
    }
}