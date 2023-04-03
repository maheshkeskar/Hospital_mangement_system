package com.mahesh101.Controller;

import com.mahesh101.CustomExaption.ReportNotFoundException;
import com.mahesh101.Repository.ReportRepository;
import com.mahesh101.assemblers.ReportModelAssembler;
import com.mahesh101.model.Report;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController

public class ReportController{
    private final ReportRepository reportRepository;
    private final ReportModelAssembler reportModelAssembler;

    public  ReportController(ReportRepository reportRepository,ReportModelAssembler reportModelAssembler){
      this.reportRepository = reportRepository;
      this.reportModelAssembler = reportModelAssembler;
    }

 @GetMapping("/reports")
    public CollectionModel<EntityModel<Report>> all(){
     List<EntityModel<Report>> report =reportRepository.findAll().stream() //
             .map(reportModelAssembler::toModel) //
             .collect(Collectors.toList());
     return  CollectionModel.of(report,  //
             linkTo(methodOn(ReportController.class).all()).withSelfRel()) ;

 }
 @GetMapping("/reports{id}")
    public  EntityModel<Report> one(@PathVariable Long id){
        Report report = reportRepository.findById(id) //
                .orElseThrow(() -> new ReportNotFoundException(id));

        return reportModelAssembler.t
 }




}
