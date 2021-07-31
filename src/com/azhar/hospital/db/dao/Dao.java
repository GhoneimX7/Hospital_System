package com.azhar.hospital.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Dao {

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://hospitalprojectdb.mysql.database.azure.com/hospital_system", "root123@hospitalprojectdb", "admin123@123");
        if (con != null) {
            return con;
        }
        return null;
    }

    public void closeConnection(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }
}
