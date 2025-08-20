package com.example.demo;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class MyServerSql {

    public static void main(String[] args) {
        MyServerSql mss = new MyServerSql();
        MyContact contact = mss.returnDetails(987654321); // Example contact number
        System.out.println(contact);
    }

    public MyContact returnDetails(int contact) {
        MyContact mss = new MyContact();
        mss.contact = contact;

        try {
            String query = "SELECT myname,contact FROM mydata WHERE contact = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/detailsofme?useSSL=false&serverTimezone=UTC",
                    "root", "root");
                 PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, contact);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    mss.myname = rs.getString("myname");
                    mss.contact = rs.getInt("contact");
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mss;
    }
}

class MyContact {
    String myname;
    int contact;

    @Override
    public String toString() {
        return "MyContact{" +
                "name='" + myname + '\'' +
                ", contact=" + contact +
                '}';
    }
}
