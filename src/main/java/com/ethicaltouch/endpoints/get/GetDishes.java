package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.QueryExecutor;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.ethicaltouch.QueryExecutor.closeConnection;

@Path("getDishes")
public class GetDishes {
    @GET
    public static Response getDishes() {
        ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish");
        Response response = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("id", resultSet.getString("id"));
                object.put("name", resultSet.getString("name"));
                object.put("imageSource", resultSet.getString("main_picture"));
                object.put("price", resultSet.getString("price"));
                object.put("description", resultSet.getString("description"));
                object.put("cookId", resultSet.getString("cook_id"));
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
