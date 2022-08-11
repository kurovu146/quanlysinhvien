/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Query;

import Object.Room;
import static VARIABLE.GlobalVariable.ID;
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
    
    public static void registerRoom(String name, String type) {
        Connection connection = null;
        PreparedStatement sttm = null;
        ResultSet result = null;
        try {
            // Lấy danh sách sinh viên
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlysinhvien", "tuanvd14", "tuanvd14");
            
            String sql = "select * from room where name=? and type=?";
            sttm = connection.prepareStatement(sql);              
            sttm.setString(1, name);           
            sttm.setString(2, type);    
            result = sttm.executeQuery();
            
            int room_id = 0, current_count = 0;
            while (result.next()) {
                room_id = Integer.parseInt(result.getString("id"));
                current_count = Integer.parseInt(result.getString("current_count")) + 1;
            }
            PreparedStatement sttm1 = null;
            String sql2 = "update room set current_count=? where id=?";
            sttm1 = connection.prepareStatement(sql2);              
            sttm1.setInt(1, room_id);           
            sttm1.setInt(2, current_count);           
            sttm1.execute();
            
            System.out.println(room_id);
            System.out.println(ID);
            PreparedStatement sttm2 = null;
            String sql3 = "update user set room_id=? where id=?";
            sttm2 = connection.prepareStatement(sql3);              
            sttm2.setInt(1, room_id);           
            sttm2.setInt(2, ID);
            sttm2.execute();    
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
