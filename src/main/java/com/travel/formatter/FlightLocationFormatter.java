package com.travel.formatter;

import com.travel.model.flight.FlightLocation;
import com.travel.service.flight.IFlightLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class FlightLocationFormatter implements Formatter<FlightLocation> {
    private IFlightLocationService flightLocationService;
    @Autowired
    public FlightLocationFormatter(IFlightLocationService flightLocationService) {
        this.flightLocationService = flightLocationService;
    }

    @Override
    public FlightLocation parse(String text, Locale locale) throws ParseException {
        return flightLocationService.findById(Long.parseLong(text));
    }

    @Override
    public String print(FlightLocation object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + ", " +object.getCode() +"]";
    }
}
