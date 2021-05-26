package pkg.ecommerce.dao;


import pkg.ecommerce.service.User;

import java.sql.*;

public class DBClass {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/ecommerce1", "root", "");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

}