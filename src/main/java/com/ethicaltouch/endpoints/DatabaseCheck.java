package com.ethicaltouch.endpoints;

import com.ethicaltouch.postgresql.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("databasecheck")
public class DatabaseCheck {

    @GET
    public Response databaseCheck() {
       Main.init();
       return Response.ok().build();
    }
}
