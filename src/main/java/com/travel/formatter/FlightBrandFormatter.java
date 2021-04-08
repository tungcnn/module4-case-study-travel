package com.travel.formatter;

import com.travel.model.flight.FlightBrand;
import com.travel.service.flight.IFlightBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class FlightBrandFormatter implements Formatter<FlightBrand> {

    private IFlightBrandService flightBrandService;

    @Autowired
    public FlightBrandFormatter(IFlightBrandService flightBrandService) {
        this.flightBrandService = flightBrandService;
    }

    @Override
    public FlightBrand parse(String text, Locale locale) throws ParseException {
        return flightBrandService.findById(Long.parseLong(text));
    }

    @Override
    public String print(FlightBrand object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
