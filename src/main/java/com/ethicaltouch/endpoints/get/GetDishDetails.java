package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.QueryExecutor;
import com.ethicaltouch.resources.Cook;
import com.ethicaltouch.resources.Dish;
import com.google.gson.Gson;

import javax.validation.constraints.NotNull;
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

@Path("getdishdetails")
public class GetDishDetails {
    public static void main(String[] args) {
        System.out.println(getDishDetails("1a", "1a"));
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static Response getDishDetails(@NotNull @QueryParam("dishid") String dishId, @NotNull @QueryParam("cookid") String cookId) {
        Response response = null;
        try {
            List<String> ingredients = new ArrayList<>();
            List<String> pictures = new ArrayList<>();
            Dish dishWithoutDetails = null;
            Cook cook = null;
            ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish WHERE id='" + dishId + "'");
            while (resultSet.next()) {
                dishWithoutDetails = new Dish(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("main_picture"),
                        resultSet.getString("description"),
                        resultSet.getString("cook_id")
                );
            }
            closeConnection();
            resultSet = QueryExecutor.init("SELECT picture_url FROM dish_picture WHERE dish_id='" + dishId + "'");
            while (resultSet.next()) {
                pictures.add(resultSet.getString("picture_url"));
            }
            closeConnection();

            resultSet = QueryExecutor.init("SELECT ingredient_name FROM dish_ingredient WHERE dish_id='" + dishId + "'");
            while (resultSet.next()) {
                ingredients.add(resultSet.getString("ingredient_name"));
            }
            closeConnection();

            resultSet = QueryExecutor.init("SELECT * FROM cook WHERE id='" + cookId + "'");
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
                        null
                );
            }
            Dish dish = new Dish(dishWithoutDetails, pictures, ingredients, cook);
            response = Response.status(Response.Status.OK)
                    .entity(new Gson().toJson(dish))
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}

