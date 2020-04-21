package com.ethicaltouch;


import java.sql.*;

public class QueryExecutor {
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs = null;

    public static ResultSet init(String sql) throws SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        String dbUrl = "jdbc:postgresql://ec2-46-137-84-173.eu-west-1.compute.amazonaws.com:5432/dei9u79711fui5?user=fssflkmowbmthm&password=1a1da7dedf2dcdafb8ef306778159223ede03555bfdfa133307762a1b4458760&sslmode=require";
        conn = DriverManager.getConnection(dbUrl);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        return rs;
    }
    public static void closeConnection() throws SQLException {
        conn.close();
        rs.close();
        stmt.close();
    }

}


