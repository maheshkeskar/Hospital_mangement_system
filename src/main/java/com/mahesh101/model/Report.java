package com.mahesh101.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_Report")
public class Report{

    private @Id
    @GeneratedValue Long id;

    private String PatientName;
    private Status status;

    public Report() {}

    public Report(String patientName, Status status) {

        this.PatientName = patientName;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.PatientName;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.PatientName = PatientName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Report))
            return false;
        Report report = (Report) o;
        return Objects.equals(this.id, report.id) && Objects.equals(this.PatientName, report.PatientName)
                && this.status == report.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.PatientName, this.status);
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + this.id + ", description='" + this.PatientName+ '\'' + ", status=" + this.status + '}';
    }
}