package com.mahesh101.CustomExaption;

public class patientNotFoundException extends RuntimeException {
    public patientNotFoundException(Long id){
        super(("Could not find restaurant"+id));
    }
}

