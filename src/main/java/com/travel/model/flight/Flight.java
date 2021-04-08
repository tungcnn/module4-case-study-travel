package com.travel.model.flight;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private Time startTime;
    private Time arriveTime;
    private String fromLocation;
    private String toLocation;
    private double price;
    @ManyToOne
    private FlightBrand flightBrand;
}
