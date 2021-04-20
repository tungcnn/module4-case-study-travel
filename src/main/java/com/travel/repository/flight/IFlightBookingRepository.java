package com.travel.repository.flight;

import com.travel.model.flight.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}
