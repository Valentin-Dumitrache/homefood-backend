package com.ethicaltouch.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import static com.ethicaltouch.postgresql.DatabaseTest.init;


@Path("databasecheck")
public class DatabaseCheck {
    @GET
    public Response databaseCheck() {
       init();
       return Response.ok().build();
    }
}
