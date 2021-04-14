package com.travel.model.flight;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "flightbrand")
@Data
public class FlightBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String code;
}
