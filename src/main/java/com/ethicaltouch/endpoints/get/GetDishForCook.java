package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.QueryExecutor;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.ethicaltouch.QueryExecutor.closeConnection;

@Path("getDishForCook")
public class GetDishForCook {
    @GET
    public static Response getDishForCook(
            @QueryParam("id") String id
    ) {
        ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish WHERE id='" + id + "'");
        Response response = null;
        String cookId = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("id", resultSet.getString("id"));
                object.put("name", resultSet.getString("name"));
                object.put("imageSource", resultSet.getString("main_picture"));
                object.put("price", resultSet.getString("price"));
                object.put("description", resultSet.getString("description"));
                cookId = resultSet.getString("cookId");
                object.put("cookId", resultSet.getString("cook_id"));
                jsonObjectArrayList.add(object);
            }
            closeConnection();
            resultSet = QueryExecutor.init("SELECT * FROM cook WHERE id='" + cookId + "'");
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("id", resultSet.getString("id"));
                object.put("firstName", resultSet.getString("first_name"));
                object.put("lastName", resultSet.getString("last_name"));
                object.put("city", resultSet.getString("city"));
                object.put("county", resultSet.getString("county"));
                object.put("description", resultSet.getString("description"));
                object.put("coverPicture", resultSet.getString("cover_picture"));
                object.put("profilePicture", resultSet.getString("profile_picture"));
                object.put("phoneNumber", resultSet.getString("phone_number"));
                jsonObjectArrayList.add(object);
            }
            response = Response.status(Response.Status.OK)
                    .entity(jsonObjectArrayList.toString())
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (Exception e) {
            System.out.println("error=" + e.getMessage());
        }
        closeConnection();
        return response;

    }
}
