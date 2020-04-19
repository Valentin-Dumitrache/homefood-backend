package com.ethicaltouch.endpoints;


import com.ethicaltouch.postgresql.PostgresqlConnection;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("createcook")
public class CreateCook {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void createCook(
            @FormParam("id") String id,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("city") String city,
            @FormParam("county") String county,
            @FormParam("description") String description,
            @FormParam("delivery") Boolean delivery,
            @FormParam("coverPicture") String coverPicture,
            @FormParam("profilePicture") String profilePicture,
            @FormParam("phoneNumber") String phoneNumber
    )
    {
        try {
            PostgresqlConnection.getConnection().createStatement().execute(String.format("INSERT INTO cook VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s ", id, firstName, lastName, city, county, description, delivery, coverPicture, profilePicture, phoneNumber));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
