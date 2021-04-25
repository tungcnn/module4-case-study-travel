package com.travel.repository.flight;

import com.travel.model.flight.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;

public interface IFlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight> findFlightsByCodeContains(String str, Pageable pageable);
    @Query(value = "call sp_findFlights(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    Iterable<Flight> searchFlight(long location1, long location2, Date date, int seat, int limit, int offset);
}
