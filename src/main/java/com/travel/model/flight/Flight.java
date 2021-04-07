package com.travel.model.flight;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
