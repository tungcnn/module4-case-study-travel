package com.travel.service.flight;

import com.travel.model.flight.FlightLocation;
import com.travel.repository.flight.IFlightLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightLocationServiceImpl implements IFlightLocationService{
    @Autowired
    private IFlightLocationRepository flightLocationRepository;

    @Override
    public Iterable<FlightLocation> findAll() {
        return flightLocationRepository.findAll();
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
