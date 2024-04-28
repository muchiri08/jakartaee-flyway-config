package com.muchiri.flywayjakartaee.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("hello")
public class HelloResource {
    
    @GET
    public Response ping(){
        return Response
                .ok("Hello and welcome!")
                .build();
    }
}
