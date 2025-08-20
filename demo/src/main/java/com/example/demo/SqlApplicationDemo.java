package com.example.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
//importing java sql packages

public class SqlApplicationDemo {
    public static void main (String[] args) {
        String url="jdbc:mysql://localhost:3306/my_experience?useSSL=false&serverTimezone=UTC";
        String userName="root";
        String password="root";
        String query="select skill from learning_topics where id_skill = 1;";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            if (rs.next()) {
                String skill=rs.getString("skill");
                System.out.println("SKILL :"+skill);
            } else {
                System.out.println("No topic found with ID = 1");
            }
            rs.close();
            st.close();
            con.close();
        }
        catch (ClassNotFoundException e) {
        System.out.println("JDBC Driver not found!");
        e.printStackTrace();
    } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
