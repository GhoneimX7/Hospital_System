package com.azhar.hospital.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Dao {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Hello!");
        Connection con = DriverManager.getConnection("jdbc:mysql://hospitalprojectdb.mysql.database.azure.com/hospital_system", "root123@hospitalprojectdb", "admin123@123");
        System.out.println("Hello!");
        if (con != null) {
            JOptionPane.showMessageDialog(null, "Connect!");
            return con;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        getConnection();

    }
}
