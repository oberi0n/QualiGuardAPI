package com.kpi.resource;


import java.util.List;

import com.kpi.resource.model.Contract;

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

@Path("/contracts")
@Produces("application/json")
@Consumes("application/json")
public class ContractResource {

    @GET
    public List<Contract> getAll() {
        return Contract.listAll();
    }

    @GET
    @Path("/{id}")
    public Contract getById(@PathParam("id") Long id) {
        return Contract.findById(id);
    }

    @POST
    @Transactional
    public Response create(Contract contract) {
        contract.persist();
        return Response.ok(contract).status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Contract updatedContract) {
        Contract contract = Contract.findById(id);
        if (contract == null) {
            return Response.status(404).build();
        }
        //contract.supplier = updatedContract.supplier;
        contract.startDate = updatedContract.startDate;
        contract.endDate = updatedContract.endDate;
        contract.amount = updatedContract.amount;
        contract.specificTerms = updatedContract.specificTerms;
        contract.status = updatedContract.status;
        return Response.ok(contract).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = Contract.deleteById(id);
        if (!deleted) {
            return Response.status(404).build();
        }
        return Response.status(204).build();
    }
}

