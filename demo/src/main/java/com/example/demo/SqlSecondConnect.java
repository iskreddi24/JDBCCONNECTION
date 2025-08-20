package com.example.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class SqlSecondConnect {
    public static void main (String[] args) {
        String url="jdbc:mysql://localhost:3306/javascript_topic?useSSL=false&serverTimezone=UTC";
        String userName="root";
        String password="root";
        String query="select * from topics";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,password);
            Statement st= con.createStatement();
            int count = st.executeUpdate("UPDATE topics SET actual_topic='javaJDBC' WHERE topic_id=2");
            System.out.println("Rows updated: " + count);
            ResultSet rs=st.executeQuery(query);

            String userData;

            while(rs.next()) {
                userData = rs.getInt(1) + " : " + rs.getString(2);
                System.out.println(userData);
            }

            rs.close();
            st.close();
            con.close();
        }
        catch (ClassNotFoundException e){
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        }catch (SQLException s){
            System.out.println("Database error occurred!");
            s.printStackTrace();
        }
    }
}
//importing java sql packages
//load and register the Driver
//Class.forName("com.mysql.cj.jdbc.Driver");
//Connection con=DriverManager.getConnection(url,)