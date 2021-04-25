package com.travel.model.flight;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private Date date;
    private Time startTime;
    private Time arriveTime;
    @ManyToOne
    private FlightLocation fromLocation;
    @ManyToOne
    private FlightLocation toLocation;
    private double price;
    @ManyToOne
    private FlightBrand flightBrand;
    private int seat = 140;

    public void bookSeat(int seat) {
        this.seat -= seat;
    }
}
