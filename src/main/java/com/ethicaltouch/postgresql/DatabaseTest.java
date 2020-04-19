package com.ethicaltouch.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void init() {
        Connection conn = null;
        Statement stmt = null;
        try{
            conn = PostgresqlConnection.getConnection();
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM dish";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                String id  = rs.getString("id");
                String name = rs.getString("name");
                String mainPicture = rs.getString("mainpicture");
                int price  = rs.getInt("price");
                String description  = rs.getString("description");
                String cookID  = rs.getString("description");

                //Display values
                System.out.println(id);
                System.out.println(name);
                System.out.println(mainPicture);
                System.out.println(price);
                System.out.println(description);
                System.out.println(cookID);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception se){
            se.printStackTrace();
        } finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2) {
                se2.printStackTrace();
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Done!");
    }
}
