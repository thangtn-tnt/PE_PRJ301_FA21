/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Trương Nhựt Thăng
 */
public class DBConnect {

    public static Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:sqlserver://localhost;databaseName=DB_PE";
        String user = "sa";
        String pass = "123456";

        try {
            //Load driver sql server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //Get connection
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return conn;
    }
}
