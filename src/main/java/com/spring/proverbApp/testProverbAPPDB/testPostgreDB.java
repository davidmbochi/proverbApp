package com.spring.proverbApp.testProverbAPPDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testPostgreDB {

    public static void main(String []  arg) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
         Connection myConnection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/springstudent","postgres","root");
         System.out.println("database connected");

    }
}
