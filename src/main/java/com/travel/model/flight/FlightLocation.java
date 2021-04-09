package com.travel.model.flight;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "flightlocation")
@Data
public class FlightLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;
}
