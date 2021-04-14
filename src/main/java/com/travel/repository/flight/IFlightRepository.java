package com.travel.repository.flight;

import com.travel.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
}
