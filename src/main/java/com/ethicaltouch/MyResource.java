package com.ethicaltouch;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("healthcheck")
public class MyResource {
    @GET
    public String getIt() {
        return "Alive!";
    }
}
