package com.travel.repository.flight;

import com.travel.model.flight.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight> findFlightsByCodeContains(String str, Pageable pageable);
}
