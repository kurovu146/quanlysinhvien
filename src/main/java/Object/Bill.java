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


public class Bill {
    int id, room_id;
    float amount;
    String title;
    Date create_at;

    public Bill() {
    }
    
    public Bill(int id, int room_id, float amount, String title, Date create_at) {
        this.id = id;
        this.room_id = room_id;
        this.amount = amount;
        this.title = title;
        this.create_at = create_at;
    }

    public Bill(int room_id, float amount, String title, Date create_at) {
        this.room_id = room_id;
        this.amount = amount;
        this.title = title;
        this.create_at = create_at;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }
    
    
}
