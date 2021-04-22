package com.travel.controller;

import com.travel.model.flight.FlightLocation;
import com.travel.model.hotel.Hotel;
import com.travel.service.flight.serviceinterface.IFlightLocationService;
import com.travel.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private IHotelService hotelService;

    @Autowired
    private IFlightLocationService flightLocationService;
    @ModelAttribute("flightlocations")
    public Page<FlightLocation> getAllFlightLocation(Pageable pageable) {
        return flightLocationService.findAll(pageable);
    }

    @ModelAttribute("hotels")
    public Page<Hotel> getAllHotel(Pageable pageable) {
        return hotelService.findAll(pageable);
    }

//    @GetMapping("/")
//    public ModelAndView getLandingPage() {
//        return new ModelAndView("/users/index");
//    }

    @GetMapping("/")
    public ModelAndView getLandingPage() {
        return new ModelAndView("/indexRoom");
    }
}
