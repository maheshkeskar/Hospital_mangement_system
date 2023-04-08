package com.mahesh101.assemblers;

import com.mahesh101.Controller.ReportController;
import com.mahesh101.model.Report;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ReportModelAssembler implements RepresentationModelAssembler<Report, EntityModel<Report>> {

    @Override
    public EntityModel<Report> toModel(Report report) {

        EntityModel<Report> reportModel = EntityModel.of(report,

                linkTo(methodOn(ReportController.class).one(report.getId())).withSelfRel(),
                linkTo(methodOn(ReportController.class).all()).withRel("all_report"));
        {


        }

        return reportModel;
    };
}

