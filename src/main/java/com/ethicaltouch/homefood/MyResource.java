package com.ethicaltouch.homefood;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("healthcheck")
public class MyResource {
    @GET
    public String getIt() {
        return "Alive!";
    }
}
