package com.travel.model.flight;

import com.travel.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Customer customer;

    public FlightBooking(Flight flight, Customer customer) {
        this.flight = flight;
        this.customer = customer;
    }
}
