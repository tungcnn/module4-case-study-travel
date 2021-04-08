package com.travel.repository.flight;

import com.travel.model.flight.FlightBrand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IFlightBrandRepository extends PagingAndSortingRepository<FlightBrand, Long> {
}
