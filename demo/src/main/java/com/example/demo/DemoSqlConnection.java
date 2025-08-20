package com.example.demo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;


//public class DemoSqlConnection {
//    public static void main (String[] args)throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//        String query="select name from student where id=2; ";
//        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_data?useSSL=false&serverTimezone=UTC","root","root");
//
//        Statement st=con.createStatement();
//        ResultSet rs= st.executeQuery(query);
//        rs.next();
//        String name=rs.getString("name");
//        System.out.println(name);
//        st.close();
//        con.close();
//    }
//}


import java.sql.*;

public class DemoSqlConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_data?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        String query = "SELECT email FROM student WHERE id = 3";
        String query1="SELECT name FROM student WHERE id=3";
        String query2="SELECT email FROM student WHERE id=1";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                String email=rs.getString("email");
                System.out.println("email :"+email);
            } else {
                System.out.println("No student found with ID = 2");
            }
            rs.close();
            st.close();


            Statement st2=con.createStatement();
            ResultSet ns=st2.executeQuery(query1);
            if (ns.next()) {
                String name = ns.getString("name");
                System.out.println("Student Name: " + name);
            } else {
                System.out.println("No student found with ID = 2");
            }
            ns.close();
            st2.close();

            Statement st3=con.createStatement();
            ResultSet cns=st3.executeQuery(query2);
            if(cns.next()){
                String email=cns.getString("email");
                System.out.println("get email :"+email);
            }else{
                System.out.println("no email found");
            }
            st3.close();
            cns.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
