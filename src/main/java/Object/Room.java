/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author DELL
 */
public class Room {
    int id, current_count, max_count;
    String name, type;

    public Room(int id, int current_count, int max_count, String name, String type) {
        this.id = id;
        this.current_count = current_count;
        this.max_count = max_count;
        this.name = name;
        this.type = type;
    }

    public Room(int current_count, int max_count, String name, String type) {
        this.current_count = current_count;
        this.max_count = max_count;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrent_count() {
        return current_count;
    }

    public void setCurrent_count(int current_count) {
        this.current_count = current_count;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
