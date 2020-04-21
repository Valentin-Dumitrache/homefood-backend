package com.ethicaltouch;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjectInitializer {
    public static JSONObject addDish(ResultSet resultSet) throws SQLException, JSONException {
        JSONObject object = new JSONObject();
        object.put("id", resultSet.getString("id"));
        object.put("name", resultSet.getString("name"));
        object.put("imageSource", resultSet.getString("main_picture"));
        object.put("price", resultSet.getString("price"));
        object.put("description", resultSet.getString("description"));
        object.put("cookId", resultSet.getString("cook_id"));
        return object;
    }
    public static JSONObject addCook(ResultSet resultSet) throws SQLException, JSONException {
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
        return object;
    }
}
