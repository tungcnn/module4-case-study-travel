package com.travel.service.flight.impl;

import com.travel.model.flight.Flight;
import com.travel.repository.flight.IFlightRepository;
import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
@Transactional
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

    @Override
    public Page<Flight> search(String string, Pageable pageable) {
        return flightRepository.findFlightsByCodeContains(string, pageable);
    }

    @Override
    public Iterable<Flight> searchFlightOnUser(long flightLocation, long flightLocation1, Date date, int seat, int limit, int offset) {
        return flightRepository.searchFlight(flightLocation, flightLocation1, date, seat, limit, offset);
    }
}
