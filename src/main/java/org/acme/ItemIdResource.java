package org.acme;

import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class ItemIdResource {

    @Path("")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ItemId generate(@RestQuery int value) {
        return new ItemId(value);
    }
}
