package com.ethicaltouch.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
@Path("healthcheck")
public class Healthcheck {
    @GET
    public String getIt() {
        return "Alive!";
    }
}