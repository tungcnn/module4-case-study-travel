package com.travel.model.flight;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime arriveTime;
    private String fromLocation;
    private String toLocation;
    private double price;
    @ManyToOne
    private FlightBrand flightBrand;
}
