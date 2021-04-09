package com.travel.repository.flight;

import com.travel.model.flight.FlightLocation;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFlightLocationRepository extends PagingAndSortingRepository<FlightLocation, Long> {
}
