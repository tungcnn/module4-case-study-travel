package com.travel.service.flight.serviceinterface;

import com.travel.model.flight.Flight;
import com.travel.service.IGeneral;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;

public interface IFlightService extends IGeneral<Flight> {
    Page<Flight> search(String string, Pageable pageable);
    Iterable<Flight> searchFlightOnUser(long flightLocation, long flightLocation1, Date date, int seat, int limit, int offset);
}
