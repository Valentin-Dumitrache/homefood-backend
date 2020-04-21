package com.ethicaltouch.endpoints.get;

import com.ethicaltouch.ObjectInitializer;
import com.ethicaltouch.QueryExecutor;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.ethicaltouch.QueryExecutor.closeConnection;

@Path("getDishesForCook")
public class GetDishesForCook {
    @GET
    public static Response getDishesForCook(
            @QueryParam("id") String id
    ) {
        Response response = null;
        ArrayList<JSONObject> jsonObjectArrayList = new ArrayList<>();
        try {
            ResultSet resultSet = QueryExecutor.init("SELECT * FROM dish WHERE cook_id='" + id + "'");
            while (resultSet.next()) {
                jsonObjectArrayList.add(ObjectInitializer.addDish(resultSet));
            }
            closeConnection();
            resultSet = QueryExecutor.init("SELECT * FROM cook WHERE id='" + id + "'" );
            while (resultSet.next()) {
                jsonObjectArrayList.add(ObjectInitializer.addCook(resultSet));
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
