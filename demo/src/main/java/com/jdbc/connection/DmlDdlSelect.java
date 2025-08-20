package com.jdbc.connection;
import java.sql.*;
public class DmlDdlSelect {
    void createTable(){
        try{
            String url="jdbc:mysql://localhost:3306/studentsiva?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            Statement st= con.createStatement();
            String query="CREATE TABLE IF NOT EXISTS STUDENT_DETAILS(NAME VARCHAR(50),AGE INT,CONTACT INT,EMAIL VARCHAR(50))";
            st.executeUpdate(query);
            System.out.println("student table created successfully created .......");
            con.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
   void updateTable(){
       try{
           String url="jdbc:mysql://localhost:3306/studentsiva?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection(url,"root","root");
           Statement st= con.createStatement();
           String query="INSERT INTO STUDENT_DETAILS VALUES('siva',22,300,'siva@gmail.com'),('suresh',23,301,'suresh@gmail.com'),('ashok',26,305,'ashok@gmail.com')";
           st.executeUpdate(query);
           System.out.println("successfully updated the data .....");
           con.close();
       }catch (ClassNotFoundException e){
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    void createSelectQuery(){
        try{
            String url="jdbc:mysql://localhost:3306/studentsiva?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            Statement st= con.createStatement();
            String query="SELECT * FROM STUDENT_DETAILS";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                String name=rs.getString("NAME");
                int age=rs.getInt("AGE");
                int contact=rs.getInt("CONTACT");
                String email=rs.getString("EMAIL");
                System.out.println("Name of the student : "+name+"\n"+"age of the student :"+age+"\n"+"contact of the person is :"+contact+"\n"+"email of the person is :"+email);
                System.out.println("details of the student .....");

            }
            con.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main (String[] args) {
        DmlDdlSelect dds=new DmlDdlSelect();
        dds.createTable();
        dds.updateTable();
        dds.createSelectQuery();
    }
}
