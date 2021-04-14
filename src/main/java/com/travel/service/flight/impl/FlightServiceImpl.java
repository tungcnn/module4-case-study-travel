package com.travel.service.flight.impl;

import com.travel.model.flight.Flight;
import com.travel.repository.flight.IFlightRepository;
import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements IFlightService {
    @Autowired
    private IFlightRepository flightRepository;

    @Override
    public Page<Flight> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    @Override
    public Flight findById(long id) {
        return flightRepository.findById(id).get();
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void delete(long id) {
        flightRepository.deleteById(id);
    }
}
