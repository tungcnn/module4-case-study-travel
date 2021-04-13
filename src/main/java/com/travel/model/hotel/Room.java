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
    private boolean available = true;
    private String detail;
    @ManyToOne
    private Hotel hotel;
}
