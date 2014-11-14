package com.mystore.resources;

import io.dropwizard.hibernate.UnitOfWork;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.mystore.core.Visit;
import com.mystore.db.VisitDAO;

@Path("/visits")
@Produces(MediaType.APPLICATION_JSON)
public class VisitResource  {

    private final VisitDAO visitDAO;

    public VisitResource(VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }
    
    @Timed(name = "createVisit")
    @POST
    @UnitOfWork
    public Visit createVist(Visit visit) {
        return visitDAO.create(visit);
    }

    @GET
    @UnitOfWork
    public List<Visit> listVisits() {
        return visitDAO.findAll();
    }
}
