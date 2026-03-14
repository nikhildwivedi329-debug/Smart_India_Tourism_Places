package com.tms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.net.URI;

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
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tourism_db_dzq6",
                    "root",
                    "Sand@#14"
            );
        }

        URI uri = new URI(dbUrl);

        String user = uri.getUserInfo().split(":")[0];
        String password = uri.getUserInfo().split(":")[1];

        String jdbcUrl = "jdbc:mysql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();

        return DriverManager.getConnection(jdbcUrl, user, password);
    }
}
