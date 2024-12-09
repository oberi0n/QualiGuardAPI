package com.kpi.resource;

import java.util.List;
import java.util.stream.Collectors;

import com.kpi.resource.dto.SupplierEvaluationCreateDTO;
import com.kpi.resource.dto.SupplierEvaluationDTO;
import com.kpi.resource.model.Contract;
import com.kpi.resource.model.Kpi;
import com.kpi.resource.model.Supplier;
import com.kpi.resource.model.SupplierEvaluation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Path("/supplier-evaluations")
@Produces("application/json")
@Consumes("application/json")
public class SupplierEvaluationResource {

    @PersistenceContext
    EntityManager entityManager;

    @GET
    public List<SupplierEvaluationDTO> getAll() {
        return SupplierEvaluation.<SupplierEvaluation>streamAll()
                .map(SupplierEvaluationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    @Transactional
    public SupplierEvaluationDTO getById(@PathParam("id") Long id) {
        SupplierEvaluation evaluation = SupplierEvaluation.findById(id);
        if (evaluation == null) {
            throw new WebApplicationException("SupplierEvaluation not found", 404);
        }
        return SupplierEvaluationDTO.fromEntity(evaluation);
    }


    @POST
    @Transactional
    public Response create(SupplierEvaluationCreateDTO createDTO) {
        SupplierEvaluation supplierEvaluation = new SupplierEvaluation();

        // Charger les entités liées (Supplier, KPI, Contract) depuis la base
        supplierEvaluation.supplier = Supplier.findById(createDTO.supplierId);
        if (supplierEvaluation.supplier == null) {
            return Response.status(400).entity("Supplier not found").build();
        }

        supplierEvaluation.kpi = Kpi.findById(createDTO.kpiId);
        if (supplierEvaluation.kpi == null) {
            return Response.status(400).entity("KPI not found").build();
        }

        supplierEvaluation.contract = Contract.findById(createDTO.contractId);
        if (supplierEvaluation.contract == null) {
            return Response.status(400).entity("Contract not found").build();
        }

        // Ajouter les autres propriétés
        supplierEvaluation.comments = createDTO.comments;
        supplierEvaluation.evaluationDate = createDTO.evaluationDate;
        supplierEvaluation.overallScore = createDTO.overallScore;

        // Persister l'entité
        supplierEvaluation.persist();

        // Retourner le DTO en réponse
        return Response.status(201)
                .entity(SupplierEvaluationDTO.fromEntity(supplierEvaluation))
                .build();
    }


    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, SupplierEvaluation updatedSupplierEvaluation) {
        SupplierEvaluation supplierEvaluation = SupplierEvaluation.findById(id);
        if (supplierEvaluation == null) {
            return Response.status(404).build();
        }

        // Mise à jour des champs
        supplierEvaluation.overallScore = updatedSupplierEvaluation.overallScore;
        supplierEvaluation.comments = updatedSupplierEvaluation.comments;

        // Mise à jour des relations si nécessaire
        if (updatedSupplierEvaluation.kpi != null) {
            supplierEvaluation.kpi = entityManager.merge(updatedSupplierEvaluation.kpi);
        }

        return Response.ok(SupplierEvaluationDTO.fromEntity(supplierEvaluation)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = SupplierEvaluation.deleteById(id);
        if (!deleted) {
            return Response.status(404).build();
        }
        return Response.status(204).build();
    }
}
