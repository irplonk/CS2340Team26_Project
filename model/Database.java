package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ben on 10/5/2016.
 */
public class Database {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9137193";
        String username = "sql9137193";
        String password1 = "UxSWTCiTJl";

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password1);
    }

}
