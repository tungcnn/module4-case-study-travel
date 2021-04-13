package com.travel.service.flight.impl;

import com.travel.model.flight.FlightLocation;
import com.travel.repository.flight.IFlightLocationRepository;
import com.travel.service.flight.serviceinterface.IFlightLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightLocationServiceImpl implements IFlightLocationService {
    @Autowired
    private IFlightLocationRepository flightLocationRepository;

    @Override
    public Page<FlightLocation> findAll(Pageable pageable) {
        return flightLocationRepository.findAll(pageable);
    }

    @Override
    public FlightLocation findById(long id) {
        return flightLocationRepository.findById(id).get();
    }

    @Override
    public void save(FlightLocation flightLocation) {
        flightLocationRepository.save(flightLocation);
    }

    @Override
    public void delete(long id) {
        flightLocationRepository.deleteById(id);
    }
}
