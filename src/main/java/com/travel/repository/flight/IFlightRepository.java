package com.travel.repository.flight;

import com.travel.model.flight.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFlightRepository extends PagingAndSortingRepository<Flight, Long> {
}
