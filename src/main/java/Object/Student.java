/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class Student {
    int id, room_id;
    String name, username, password, email, mssv;
    Date dob;

    public Student() {
    }

    public Student(int id, int room_id, String name, String username, String password, String email, String mssv, Date dob) {
        this.id = id;
        this.room_id = room_id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mssv = mssv;
        this.dob = dob;
    }

    public Student(int id, int room_id, String name, String email, String mssv, Date dob) {
        this.id = id;
        this.room_id = room_id;
        this.name = name;
        this.email = email;
        this.mssv = mssv;
        this.dob = dob;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
