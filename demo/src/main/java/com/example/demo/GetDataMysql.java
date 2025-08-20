package com.example.demo;
import java.sql.*;

public class GetDataMysql {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Student s1 = dao.getStudent(1);
        Student s2 = dao.getStudent(2);
        Student s3 = dao.getStudent(3);
        Student s4 = dao.getStudent(4);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
    }
}

class StudentDAO {
    public Student getStudent(int rollno) {
        Student student = new Student();
        student.rollno = rollno;

        String query = "SELECT sname FROM student WHERE rollno=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/KRISHNA?useSSL=false&serverTimezone=UTC",
                    "root", "root");
                 PreparedStatement pst = con.prepareStatement(query)) {

                pst.setInt(1, rollno);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        student.sname = rs.getString(1);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}

class Student {
    int rollno;
    String sname;

    @Override
    public String toString () {
        return "Student{" +
                "rollno=" + rollno +
                ", sname='" + sname + '\'' +
                '}';
    }
}
