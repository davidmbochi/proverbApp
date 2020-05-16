package com.spring.proverbApp.testProverbSecurityDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testPostgreSecurityDB {
    public static void main(String arg []){
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/springsecurity","postgres","root");
            System.out.println("database connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
