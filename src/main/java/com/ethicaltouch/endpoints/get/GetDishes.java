package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.QueryExecutor;
import com.ethicaltouch.resources.Dish;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.ethicaltouch.QueryExecutor.closeConnection;

@Path("getdishes")
public class GetDishes {
    public static void main(String[] args) {
        System.out.println(getDishes("1a").getEntity());
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getDishes(@QueryParam("cookid") String cookId) {
        Response response = null;
        List<Dish> dishes = new ArrayList<>();
        try {
            String query;
            if(cookId != null) {
                query = "SELECT * FROM dish WHERE cook_id='" + cookId + "'";
            } else {
                query = "SELECT * FROM dish";
            }
            ResultSet resultSet = QueryExecutor.init(query);
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
            response = Response.status(Response.Status.OK)
                    .entity(dishes)
                    .header("Access-Control-Allow-Origin", "*")
            .build();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;

    }
}
