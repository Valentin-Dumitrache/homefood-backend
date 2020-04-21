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

@Path("getDishPictures")
public class GetDishPictures {
    @GET
    public static Response getDishPictures(
            @QueryParam("id") String id
    ) {
        ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish_picture WHERE dish_id='" + id + "'");
        Response response = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("pictureName", resultSet.getString("picture_url"));
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
