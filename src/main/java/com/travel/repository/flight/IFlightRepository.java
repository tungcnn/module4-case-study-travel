package com.travel.repository.flight;

import com.travel.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
}
