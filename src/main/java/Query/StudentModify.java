/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import Object.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static VARIABLE.GlobalVariable.ID;

/**
 *
 * @author DELL
 */
public class StudentModify {
    public static Student getStudentByUsername(String username) {
        Connection connection = null;
        PreparedStatement sttm = null;
        ResultSet result = null;
        Student std = new Student();
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from user where username=?";
            sttm = connection.prepareStatement(sql);              
            sttm.setString(1, username);
            
            result = sttm.executeQuery();
            while (result.next()) {
                std.setPassword(result.getString("password"));
                ID = result.getInt("id");
                System.out.println(std);
                return std;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error" + ex.toString());
                }
            }
        }
        return null;
    }
    public static Student getStudentByMssv(String mssv) {
        Connection connection = null;
        PreparedStatement sttm = null;
        ResultSet result = null;
        Student std = new Student();
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from user where mssv=?";
            sttm = connection.prepareStatement(sql);              
            sttm.setString(1, mssv);
            
            result = sttm.executeQuery();
            while (result.next()) {
                std.setId(result.getInt("id"));
                std.setRoom_id(result.getInt("room_id"));
                std.setName(result.getString("name"));
                std.setEmail(result.getString("email"));
                std.setMssv(result.getString("mssv"));
                std.setDob(result.getString("dob"));
                return std;
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error" + ex.toString());
                }
            }
        }
        return null;
    }
    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from user";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student std = new Student(
                        resultSet.getInt("id"),
                        resultSet.getInt("room_id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("mssv"),
                        resultSet.getString("dob")
                );
                studentList.add(std);
            }     
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error" + ex.toString());
                }
            }
        }
        
        return studentList;
    }
    
    public static void updateStudent(Student std) {
        Connection connection = null;
        PreparedStatement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "update user set name=?,email=?,mssv=?,dob=? where id = ?";
            statement = connection.prepareCall(sql);
              
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setString(3, std.getMssv());
            statement.setString(4, std.getDob());
            statement.setInt(5, std.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            System.out.println("Error" + ex.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    System.out.println("Error" + ex.toString());
                }
            }
        }
    }
}
