package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.ObjectInitializer;
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
        Response response = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish");
            while (resultSet.next()) {
                jsonObjectArrayList.add(ObjectInitializer.addDish(resultSet));
            }
            response = Response.status(Response.Status.OK)
                    .entity(jsonObjectArrayList.toString())
                    .header("Access-Control-Allow-Origin", "*")
            .build();
            closeConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;

    }
}
