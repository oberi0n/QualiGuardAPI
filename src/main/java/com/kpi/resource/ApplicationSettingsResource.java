package com.kpi.resource;

import java.util.List;

import com.kpi.resource.model.ApplicationSettings;

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

@Path("/application-settings")
@Produces("application/json")
@Consumes("application/json")
public class ApplicationSettingsResource {

    @GET
    public List<ApplicationSettings> getAll() {
        return ApplicationSettings.listAll();
    }

    @GET
    @Path("/{id}")
    public ApplicationSettings getById(@PathParam("id") Long id) {
        return ApplicationSettings.findById(id);
    }

    @POST
    @Transactional
    public Response create(ApplicationSettings settings) {
        settings.persist();
        return Response.ok(settings).status(201).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, ApplicationSettings updatedSettings) {
        ApplicationSettings settings = ApplicationSettings.findById(id);
        if (settings == null) {
            return Response.status(404).build();
        }
        settings.instanceId = updatedSettings.instanceId;
        settings.settingName = updatedSettings.settingName;
        settings.value = updatedSettings.value;
        settings.settingType = updatedSettings.settingType;
        settings.description = updatedSettings.description;
        return Response.ok(settings).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = ApplicationSettings.deleteById(id);
        if (!deleted) {
            return Response.status(404).build();
        }
        return Response.status(204).build();
    }
}
