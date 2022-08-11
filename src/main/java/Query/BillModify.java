/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import Object.Bill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class BillModify {
    public static List<Bill> findAll() {
        List<Bill> billList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from bill";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bill bill = new Bill(                        
                        resultSet.getInt("id"),                        
                        resultSet.getInt("room_id"),
                        resultSet.getFloat("amount"),
                        resultSet.getString("title"),
                        resultSet.getDate("create_at")
                );
                billList.add(bill);
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
        
        return billList;
    }
    
    public static List<Bill> getBillByRooom(String name, String type) {
        List<Bill> billList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement sttm = null;
        ResultSet result = null;
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select id from room where name=? and type=?";
            sttm = connection.prepareStatement(sql);              
            sttm.setString(1, name);            
            sttm.setString(2, type);
            int room_id = 0;
            result = sttm.executeQuery();
            while (result.next()) {
                room_id = result.getInt("id");
            }
            
            PreparedStatement sttm1 = null;
            String sql1 = "select * from bill where room_id=?";
            sttm1 = connection.prepareStatement(sql1);              
            sttm1.setInt(1, room_id);            
            result = sttm1.executeQuery();
            while (result.next()) {
                Bill bill = new Bill(                        
                        result.getInt("id"),                        
                        result.getInt("room_id"),
                        result.getFloat("amount"),
                        result.getString("title"),
                        result.getDate("create_at")
                );
                billList.add(bill);
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
        
        return billList;
    }
    
    public static void insertBill(Bill bill) {
        Connection connection = null;
        PreparedStatement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "insert into bill(room_id, amount, title, create_at) value(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
              
            statement.setInt(1, bill.getRoom_id());
            statement.setFloat(2, bill.getAmount());
            statement.setString(3, bill.getTitle());
            statement.setDate(4, bill.getCreate_at());
            
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
