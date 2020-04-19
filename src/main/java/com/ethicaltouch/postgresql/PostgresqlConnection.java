package com.ethicaltouch.postgresql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnection {
    public static Connection getConnection() throws SQLException {
//        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String dbUrl = "jdbc:postgresql://ec2-46-137-84-173.eu-west-1.compute.amazonaws.com:5432/dei9u79711fui5?user=fssflkmowbmthm&password=1a1da7dedf2dcdafb8ef306778159223ede03555bfdfa133307762a1b4458760&sslmode=require\n";
        return DriverManager.getConnection(dbUrl);
    }
}