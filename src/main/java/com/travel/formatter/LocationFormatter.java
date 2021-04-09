package com.travel.formatter;

import com.travel.model.tour.Location;
import com.travel.service.tour.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class LocationFormatter implements Formatter<Location> {

    private ILocationService locationService;

    @Autowired
    public LocationFormatter(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Location parse(String text, Locale locale) throws ParseException {
        return locationService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Location object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
