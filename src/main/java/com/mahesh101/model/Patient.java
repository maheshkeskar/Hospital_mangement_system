package com.mahesh101.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Patient {
    private @Id @GeneratedValue Long ID;
    private String patientName;
    private String DiseaseName;
    private long PatientRegistration;
    private  String Bed;
    private String Billing;

    public Patient(String patientName, String DiseaseName, long patientRegistration, String bed, String billing) {
        this.patientName=patientName;
       this. DiseaseName= DiseaseName;
        PatientRegistration = patientRegistration;
        Bed = bed;
        Billing = billing;
    }
}
