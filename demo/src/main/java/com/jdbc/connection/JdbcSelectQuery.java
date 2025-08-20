package com.jdbc.connection;
import java.sql.*;
public class JdbcSelectQuery {
    void createDB(){
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/jdbc_con?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,"root","root");
            Statement st= con.createStatement();
            String query="SELECT * FROM AccountHolder";
            ResultSet rs= st.executeQuery(query);
            while(rs.next()){
                String name=rs.getString("Name");
                String address=rs.getString("Address");
                float balance=rs.getFloat("Balance");
                System.out.println("Name of the person is : "+name+",address of the person "+address+" and the balance of the person is "+balance);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args) {
JdbcSelectQuery jsq=new JdbcSelectQuery();
jsq.createDB();
    }
}
