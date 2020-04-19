package com.ethicaltouch.postgresql;

import java.sql.SQLException;

import static com.ethicaltouch.postgresql.PostgresqlConnection.getConnection;

public class DatabaseTest {
    public static void main(String[] args) {
        init();
    }
    public static void init() {
        try {
            getConnection().createStatement().executeQuery("CREATE TABLE TEST (test varchar)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
