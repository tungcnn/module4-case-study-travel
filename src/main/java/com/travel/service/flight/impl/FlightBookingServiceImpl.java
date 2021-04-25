package com.travel.service.flight.impl;

import com.travel.model.flight.FlightBooking;
import com.travel.repository.flight.IFlightBookingRepository;
import com.travel.service.flight.serviceinterface.IFlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlightBookingServiceImpl implements IFlightBookingService {
    @Autowired
    private IFlightBookingRepository flightBookingRepository;
    @Override
    public Page<FlightBooking> findAll(Pageable pageable) {
        return flightBookingRepository.findAll(pageable);
    }

    @Override
    public FlightBooking findById(long id) {
        return flightBookingRepository.findById(id).get();
    }

    @Override
    public void save(FlightBooking flightBooking) {
        flightBookingRepository.save(flightBooking);
    }

    @Override
    public void delete(long id) {
        flightBookingRepository.deleteById(id);
    }
}
