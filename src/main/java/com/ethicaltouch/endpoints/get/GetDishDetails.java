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

@Path("getdishdetails")
public class GetDishDetails {
    @GET
    public static Response getDishDetails(@NotNull @QueryParam("dishid") String dishId) {
        Response response = null;
        try {
            List<String> ingredients = new ArrayList<>();
            List<String> pictures = new ArrayList<>();
            List<String> labels = new ArrayList<>();
            Dish dish = null;
            Cook cook = null;
            ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish WHERE id='" + dishId + "'");
            while (resultSet.next()) {
                dish = new Dish(
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getString("main_picture"),
                        resultSet.getString("description"),
                        resultSet.getString("cook_id"),
                        resultSet.getString("section")
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

            resultSet = QueryExecutor.init("SELECT label_name FROM dish_label WHERE dish_id='" + dishId + "'");
            while (resultSet.next()) {
                labels.add(resultSet.getString("label_url"));
            }
            closeConnection();

            resultSet = QueryExecutor.init("SELECT * FROM cook WHERE id='" + dish.getCookId() + "'");
            while(resultSet.next()) {
                cook = new Cook(
                        dish.getCookId(),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("city"),
                        resultSet.getString("county"),
                        resultSet.getString("description"),
                        resultSet.getString("cover_picture"),
                        resultSet.getString("profile_picture"),
                        resultSet.getString("phone_number")
                );
            }
            Dish dishWithDetails = new Dish(dish, pictures, ingredients, labels, cook);
            response = Response.status(Response.Status.OK)
                    .entity(new Gson().toJson(dishWithDetails))
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}

