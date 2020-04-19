package com.ethicaltouch.endpoints;

import com.ethicaltouch.postgresql.Main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.SQLException;


@Path("databasecheck")
public class DatabaseCheck {

    @GET
    public String databaseCheck() {
        try {
            return Main.myRealMainMethod();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Didn't work";
    }
}
