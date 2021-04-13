package com.travel.repository.flight;

import com.travel.model.flight.FlightBrand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightBrandRepository extends JpaRepository<FlightBrand, Long> {
}
