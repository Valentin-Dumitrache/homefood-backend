package com.ethicaltouch.postgresql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class Main {

    @Autowired
    private static DataSource dataSource;

    public static void init() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class.getPackage().getName());
    }

    @PostConstruct
    public static String myRealMainMethod() throws SQLException {
        Statement stmt = dataSource.getConnection().createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
        stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        while (rs.next()) {
            return "Read from DB: " + rs.getTimestamp("tick");
        }
        return "Didn't work";
    }

}