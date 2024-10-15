package com.n3.miniproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/quanlybook";
    private static final String USER="root";
    private static final String PASS="123456";

    public static Connection openConnect(){
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PASS);
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void closeConnect(Connection connection){
        if (connection!= null){
            try {
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        Connection connection=ConnectionDB.openConnect();
    }
}
