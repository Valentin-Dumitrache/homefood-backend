package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.postgresql.PostgresqlConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("getDishes")
public class GetDishes {
    @GET
    public ResultSet getDishes() {
        ResultSet resultSet = null;
        try {
            resultSet = PostgresqlConnection.getConnection().createStatement().executeQuery("SELECT * FROM dish");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
