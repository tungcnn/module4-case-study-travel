package com.travel.service.flight;

import com.travel.model.flight.Flight;
import com.travel.repository.flight.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements IFlightService{
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public Iterable<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findById(long id) {
        return flightRepository.findOne(id);
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void delete(long id) {
        flightRepository.delete(id);
    }
}
