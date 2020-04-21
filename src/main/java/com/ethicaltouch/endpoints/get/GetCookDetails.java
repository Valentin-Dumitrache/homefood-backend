package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.QueryExecutor;
import com.ethicaltouch.resources.Cook;
import com.ethicaltouch.resources.Dish;
import com.google.gson.Gson;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.ethicaltouch.QueryExecutor.closeConnection;

@Path("getcookdetails")
public class GetCookDetails {
    @GET
    public static Response getCookDetails(@NotNull @QueryParam("cookid") String cookId) {
        Response response = null;
        List<Dish> dishes = new ArrayList<>();
        Cook cook = null;
        try {
            ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish WHERE cook_id='" + cookId + "'");
            while (resultSet.next()) {
                Dish dish = new Dish(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("main_picture"),
                        resultSet.getString("description"),
                        resultSet.getString("cook_id")
                );
                dishes.add(dish);
            }
            closeConnection();
            resultSet = QueryExecutor.init("SELECT * FROM cook WHERE id='" + cookId + "'" );
            while(resultSet.next()) {
                cook = new Cook(
                        cookId,
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("city"),
                        resultSet.getString("county"),
                        resultSet.getString("description"),
                        resultSet.getString("cover_picture"),
                        resultSet.getString("profile_picture"),
                        resultSet.getString("phone_number"),
                        dishes
                );
            }
            response = Response.status(Response.Status.OK)
                    .entity(new Gson().toJson(cook))
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
