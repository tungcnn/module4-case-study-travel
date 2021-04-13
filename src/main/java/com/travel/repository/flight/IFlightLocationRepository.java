package com.travel.repository.flight;

import com.travel.model.flight.FlightLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightLocationRepository extends JpaRepository<FlightLocation, Long> {
}
