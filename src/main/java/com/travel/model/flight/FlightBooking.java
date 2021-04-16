package com.travel.model.flight;

import com.travel.model.AppUser;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private AppUser appUser;
}
