/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import Object.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class RoomModify {
    public static List<Room> findAll() {
        List<Room> roomList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from room";
            statement = connection.createStatement();
            
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Room room = new Room(                        
                        resultSet.getInt("id"),
                        resultSet.getInt("current_count"),
                        resultSet.getInt("max_count"),
                        resultSet.getString("name"),
                        resultSet.getString("type")
                );
                roomList.add(room);
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
        
        return roomList;
    }
    
    public static void registerRoom() {
        Connection connection = null;
        PreparedStatement statement = null;
     
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "update room set current_count=? where name=? and type=?";
            statement = connection.prepareCall(sql);
              
            statement.setString(1, std.getName());
            statement.setString(2, std.getEmail());
            statement.setString(3, std.getMssv());
            statement.setDate(4, std.getDob());
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
