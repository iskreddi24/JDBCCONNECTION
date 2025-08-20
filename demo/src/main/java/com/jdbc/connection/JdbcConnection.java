package com.jdbc.connection;
import java.sql.*;
public class JdbcConnection {
    void createDB(){
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/jdbc_con?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,"root","root");
            Statement st= con.createStatement();
            String query="CREATE TABLE AccountHolder(Name varchar(50),Address VARCHAR(50),Balance FLOAT)";
            st.executeUpdate(query);
            con.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void main (String[] args) {
        JdbcConnection jd=new JdbcConnection();
        jd.createDB();
    }
}
