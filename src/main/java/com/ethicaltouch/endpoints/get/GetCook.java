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

@Path("getCooks")
public class GetCook {
    @GET
    public static Response getCook(
            @QueryParam("id") String id
    ) {
        ResultSet resultSet = QueryExecutor.init("SELECT * FROM cook WHERE 'id' = " + id );
        Response response = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                JSONObject object = new JSONObject();
                object.put("id", resultSet.getString("id"));
                object.put("firstName", resultSet.getString("firstName"));
                object.put("lastName", resultSet.getString("lastName"));
                object.put("city", resultSet.getString("city"));
                object.put("county", resultSet.getString("county"));
                object.put("description", resultSet.getString("description"));
                object.put("coverPicture", resultSet.getString("coverPicture"));
                object.put("profilePicture", resultSet.getString("profilePicture"));
                object.put("phoneNumber", resultSet.getString("phoneNumber"));
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
