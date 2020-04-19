package com.ethicaltouch;


import java.sql.*;

public class QueryExecutor {
    public static ResultSet init(String sql) {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//        String dbUrl = "jdbc:postgresql://ec2-46-137-84-173.eu-west-1.compute.amazonaws.com:5432/dei9u79711fui5?user=fssflkmowbmthm&password=1a1da7dedf2dcdafb8ef306778159223ede03555bfdfa133307762a1b4458760&sslmode=require";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(dbUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            stmt.close();
//            conn.close();
//            rs.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//                se2.printStackTrace();
//            }
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
        }
        System.out.println(rs);
        return rs;
    }
}


