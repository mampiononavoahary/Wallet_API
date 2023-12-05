package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    private String url;
    private String user;
    private String password;


    public ConnectDatabase(){
        this.url = "jdbc:postgresql://localhost:5432/"+System.getenv("DB_URL");
        this.user = System.getenv("DB_USER");
        this.password = System.getenv("DB_PASSWORD");
    }

    public Connection CreateConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");


        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}

