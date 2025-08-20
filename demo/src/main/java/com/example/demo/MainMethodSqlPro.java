package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainMethodSqlPro {

    public ClassMainSql returnName(int rollno) {
        ClassMainSql cms = new ClassMainSql();
        cms.rollno = rollno;
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/KRISHNA?useSSL=false&serverTimezone=UTC",
                "root", "root");
             PreparedStatement ps = con.prepareStatement(
                     "SELECT rollno, sname FROM student WHERE rollno = ?")) {

            ps.setInt(1, rollno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cms.sname = rs.getString(2);
                } else {
                    cms.sname = "No student found";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error occurred", e);
        }

        return cms;
    }

    public static void main(String[] args) {
        MainMethodSqlPro mainMethod = new MainMethodSqlPro();

        // Correctly capture and print the returned object
        ClassMainSql student = mainMethod.returnName(2);
        System.out.println(student);
    }
}