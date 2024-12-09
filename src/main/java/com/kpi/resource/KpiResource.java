package com.kpi.resource;
import java.util.List;

import com.kpi.resource.model.Kpi;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/kpis")
@Produces("application/json")
@Consumes("application/json")
public class KpiResource {

    @GET
    public List<Kpi> getAll() {
        return Kpi.listAll();
    }

    @GET
    @Path("/{id}")
    public Kpi getById(@PathParam("id") Long id) {
        return Kpi.findById(id);
    }

    @POST
    @Transactional
    public Response create(Kpi kpi) {
        kpi.persist();
        return Response.ok(kpi).status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Kpi updatedKpi) {
        Kpi kpi = Kpi.findById(id);
        if (kpi == null) {
            return Response.status(404).build();
        }
        kpi.name = updatedKpi.name;
        kpi.description = updatedKpi.description;
        kpi.kpiType = updatedKpi.kpiType;
        kpi.unit = updatedKpi.unit;
        kpi.value = updatedKpi.value;
        return Response.ok(kpi).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Kpi.deleteById(id);
        if (!deleted) {
            return Response.status(404).build();
        }
        return Response.status(204).build();
    }
}
