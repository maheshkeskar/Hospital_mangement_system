package com.mahesh101.assemblers;

import com.mahesh101.Controller.PatientController;
import com.mahesh101.model.Patient;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@Qualifier("patientModelAssembler")
public class PatientModelAssembler implements RepresentationModelAssembler<Patient, EntityModel<Patient>> {
    @Override
    public EntityModel<Patient> toModel(Patient patient){
        return EntityModel.of(patient,
                linkTo(methodOn(PatientController.class).one(patient.getID())).withSelfRel(),
                linkTo((methodOn(PatientController.class).all())).withRel("all patient"));

    }

}
