package com.mahesh101.assemblers;

import com.mahesh101.model.Report;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ReportModelAssembler implements RepresentationModelAssembler<Report, EntityModel<Report>> {

    @Component
    public EntityModel<Report> tomodel
}
