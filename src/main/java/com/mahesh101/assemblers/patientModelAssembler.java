package com.mahesh101.assemblers;

import com.mahesh101.model.Patient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
@Qualifier("patientModelAssembler")
public class patientModelAssembler implements RepresentationModelAssembler<Patient, EntityModel<Patient>> {
@Override
    public EntityModel<Patient> toModel(Patient patient){
    return EntityModel.of(patient,
            linkTo(methodOn(Patient)))
}

}
