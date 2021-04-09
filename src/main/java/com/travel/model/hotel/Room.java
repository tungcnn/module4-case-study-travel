package com.travel.model.hotel;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private double price;
    private int slot;
    private boolean available;
    private String detail;
    @ManyToOne
    private Hotel hotel;

    public Room() {
    }

    public Room(String name, String type, double price, int slot, boolean available, String detail, Hotel hotel) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.slot = slot;
        this.available = available;
        this.detail = detail;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return String.format("Room [id = %d, Name = %s, Type = %s, Price = %f, Slot = %d, Detail = %s", id, name, type, price, slot, detail);
    }
}
