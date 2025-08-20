package com.example.demo;
import java.sql.*;
public class DataReSql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_details?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        String query = "SELECT * FROM college";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query)
        ) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("MY_NAME");
                String email = rs.getString("EMAIL");
                String dept = rs.getString("DEPARTMENT");
                String college = rs.getString("COLLEGE");
                System.out.println(id + " ----- " + name + " ----- " + email + " ----- " + dept + " ----- " + college);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
