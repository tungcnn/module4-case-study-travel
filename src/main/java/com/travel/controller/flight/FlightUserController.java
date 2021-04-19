package com.travel.controller.flight;

import com.travel.model.flight.Flight;
import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@RestController
@RequestMapping("/flights/users/")
public class FlightUserController {
    @Autowired
    private IFlightService flightService;
    @GetMapping("/search")
    public ModelAndView getSearchResult(
            @RequestParam("radio") String radio,
            @RequestParam("fromLocation") String fromLocation,
            @RequestParam("departure") String departureDate,
            @RequestParam("return") String returnDate,
            @RequestParam("adult") String adult,
            @RequestParam("child") String child,
            @RequestParam("toLocation") String toLocation,
            Pageable pageable) {
        long fromID = Long.parseLong(fromLocation);
        long toID = Long.parseLong(toLocation);
        int total = Integer.parseInt(adult) + Integer.parseInt(child);
        Date date1 = Date.valueOf(departureDate);

        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber()*limit;

        ModelAndView modelAndView = new ModelAndView("/");
        Iterable<Flight> flights = flightService.searchFlightOnUser(fromID, toID, date1, total, limit, offset);
        modelAndView.addObject("flights", flights);
        if (radio.equals("round")) {
            Date date2 = Date.valueOf(returnDate);
            Iterable<Flight> returnFlights = flightService.searchFlightOnUser(toID, fromID, date2, total, limit, offset);
            modelAndView.addObject("returnFlights", returnFlights);
            return modelAndView;
        }
        return modelAndView;
    }
}
