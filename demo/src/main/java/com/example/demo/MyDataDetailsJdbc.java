package com.example.demo;
import java.io.InvalidClassException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class MyDataDetailsJdbc {
    public static void main (String[] args) {
        String url="jdbc:mysql://localhost:3306/my_details?useSSL=false&serverTimezone=UTC";
        String userName="root";
        String password="root";
        String query="select * from college;";
        String query1="UPDATE college SET COLLEGE='VRSEC' WHERE ID=1";
        int id=24;
        String myName="prabhas krishna";
        String email="suwwi@gmail.com";
        String branch="CSE";
        String college="VIT";
        String query3="insert into college values (?,?,?,?,?)";
//        String query2="drop table college";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,userName,password);
            Statement st=con.createStatement();
            PreparedStatement ps=con.prepareStatement(query3);
            ps.setInt(1,id);
            ps.setString(2,myName);
            ps.setString(3,email);
            ps.setString(4,branch);
            ps.setString(5,college);
            int count= ps.executeUpdate();
            System.out.println(count);
//            int count2=st.executeUpdate(query2);
//            System.out.println(count2);
            int counts= st.executeUpdate(query1);
            System.out.println(counts);
            ResultSet rs=st.executeQuery(query);

            String userData;
            while(rs.next()){
                userData=rs.getInt(1)+" : "+rs.getString(2);
                System.out.println(userData);
            }

            st.close();
            ps.close();
            con.close();

        }catch (ClassNotFoundException e){
            System.out.println("JDBC Driver not found!");
           e.printStackTrace();
        }catch (SQLException e){
            System.out.println("Database error occurred!");
            e.printStackTrace();
        }
    }
}
