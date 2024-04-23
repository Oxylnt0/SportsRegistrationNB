package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public Connection connect;

    public Connection getConnection() throws SQLException {
        //String username = "root";
        //String password = "sql061404";
        String url = "jdbc:derby://localhost:1527/player;user=me;password=me";

        //Class.forName("com.mysql.cj.jdbc.Driver");

        //connect = DriverManager.getConnection(url, username, password);

        connect = DriverManager.getConnection(url);

        return connect;
    }
}
