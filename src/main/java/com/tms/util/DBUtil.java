package com.tms.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception {

        String dbUrl = System.getenv("DATABASE_URL");

        if (dbUrl == null) {
            dbUrl = "jdbc:mysql://localhost:3306/tourism_db_dzq6";
            return DriverManager.getConnection(dbUrl, "root", "Sand@#14");
        }

        dbUrl = dbUrl.replace("mysql://", "jdbc:mysql://");

        return DriverManager.getConnection(dbUrl);
    }
}
