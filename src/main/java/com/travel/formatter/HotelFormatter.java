package com.travel.formatter;

import com.travel.model.hotel.Hotel;
import com.travel.service.hotel.HotelServiceImpl;
import com.travel.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class HotelFormatter implements Formatter<Hotel> {
    private IHotelService hotelService;

    @Autowired
    public HotelFormatter(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public Hotel parse(String text, Locale locale) throws ParseException {
        return hotelService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Hotel object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
