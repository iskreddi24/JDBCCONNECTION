package com.example.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;
public class SecondSqlConnection {
    public static void main (String[] args) {
        String url="jdbc:mysql://localhost:3306/my_experience?useSSL=false&serverTimezone=UTC";
        String userName="root";
        String password="root";
        String query="select*from learning_topics";
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection(url,userName,password);
          Statement st=con.createStatement();
          ResultSet rs= st.executeQuery(query);
            String userData="";
          rs.next();
              userData=rs.getInt(1)+" : "+rs.getString(2);
              System.out.println(userData);
            rs.next();
            userData=rs.getInt(1)+" : "+rs.getString(2);
            System.out.println(userData);

              System.out.println("here ho the id or id skill is not found");

        }catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
