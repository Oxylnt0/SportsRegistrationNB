package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection connect;

    public static Connection getConnection() throws SQLException {
        //String username = "root";
        //String password = "sql061404";
        String url = "jdbc:derby://localhost:1527/player";

        //Class.forName("com.mysql.cj.jdbc.Driver");

        //connect = DriverManager.getConnection(url, username, password);

        connect = DriverManager.getConnection(url);

        return connect;
    }
}
