package com.jdbc.connection;

import java.sql.SQLException;
import java.sql.*;
public class DmlStatemntJdbc {
    void createDB(){
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            String url="jdbc:mysql://localhost:3306/jdbc_con?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Connection con=DriverManager.getConnection(url,"root","root");
            Statement st=con.createStatement();
            String query="INSERT INTO AccountHolder VALUES('ramu','vijayawada','3000'),('krishna','guntur','4000'),('siva','hyderabad','9000')";
            st.executeUpdate(query);
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
        DmlStatemntJdbc dml=new DmlStatemntJdbc();
        dml.createDB();
    }
}
