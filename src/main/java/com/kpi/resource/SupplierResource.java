package com.kpi.resource;


import java.util.List;

import com.kpi.resource.model.Contract;
import com.kpi.resource.model.Supplier;

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

@Path("/suppliers")
@Produces("application/json")
@Consumes("application/json")
public class SupplierResource {

    @GET
    public List<Supplier> getAll() {
        return Supplier.listAll();
    }

    @GET
    @Path("/{id}")
    public Supplier getById(@PathParam("id") Long id) {
        return Supplier.findById(id);
    }

    @GET
    @Path("/contract/{supplierId}")
    public List<Contract> getContractsBySupplier(@PathParam("supplierId") Long supplierId) {
        return Contract.list("supplier.id", supplierId);
    }

    @POST
    @Transactional
    public Response create(Supplier supplier) {
        supplier.persist();
        return Response.ok(supplier).status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Supplier updatedSupplier) {
        Supplier supplier = Supplier.findById(id);
        if (supplier == null) {
            return Response.status(404).build();
        }
        supplier.name = updatedSupplier.name;
        supplier.address = updatedSupplier.address;
        supplier.contactName = updatedSupplier.contactName;
        supplier.contactEmail = updatedSupplier.contactEmail;
        supplier.contactPhone = updatedSupplier.contactPhone;
        supplier.businessSector = updatedSupplier.businessSector;
        supplier.status = updatedSupplier.status;
        return Response.ok(supplier).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Supplier.deleteById(id);
        if (!deleted) {
            return Response.status(404).build();
        }
        return Response.status(204).build();
    }
}

