package com.mahesh101.Controller;

import com.mahesh101.CustomExaption.patientNotFoundException;
import com.mahesh101.Repository.PatientRepository;
import com.mahesh101.assemblers.PatientModelAssembler;
import com.mahesh101.model.Patient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Slf4j
public class PatientController {
    private final PatientRepository patientRepository;
    private final PatientModelAssembler patientModelAssembler;

    PatientController(PatientRepository patientRepository, PatientModelAssembler patientModelAssembler) {
        this.patientModelAssembler = patientModelAssembler;
        log.info("PatientModelRepository bean:" + patientRepository.toString());
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patient")

     public CollectionModel<EntityModel<Patient>>all(){
        List<EntityModel<Patient>>patient =(List<EntityModel<Patient>>) patientRepository.findAll()
                .stream()
                .map(patientModelAssembler::toModel)
                .toList();
        return  CollectionModel.of(patient,
                linkTo(methodOn(PatientController.class).all()).withSelfRel());

    }
    @GetMapping("/Patient/{id}")
    public EntityModel<Patient>one(@PathVariable(name="id",required = true)Long id){
        Patient patient = patientRepository.findById(id).orElseThrow(()->new patientNotFoundException(id));
        return  patientModelAssembler.toModel(patient);
    }

    @PostMapping("/3")
    ResponseEntity<?> newPatient(@RequestBody Patient newPatient){
        EntityModel<Patient>entityModel = patientModelAssembler.toModel(patientRepository.save(newPatient));
        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

}
