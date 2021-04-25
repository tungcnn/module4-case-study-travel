package com.travel.controller.flight;

import com.travel.model.Customer;
import com.travel.model.flight.Flight;
import com.travel.model.flight.FlightBooking;
import com.travel.service.ICustomerService;
import com.travel.service.flight.serviceinterface.IFlightBookingService;
import com.travel.service.flight.serviceinterface.IFlightLocationService;
import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/flights/users/")
public class FlightBookingController {
    @Autowired
    private IFlightService flightService;
    @Autowired
    private IFlightLocationService flightLocationService;
    @Autowired
    private IFlightBookingService flightBookingService;
    @Autowired
    private ICustomerService customerService;

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

        ModelAndView modelAndView = new ModelAndView("/user/flight-result");
        modelAndView.addObject("radio", radio);
        modelAndView.addObject("fromLocation", flightLocationService.findById(Long.parseLong(fromLocation)).getName());
        modelAndView.addObject("toLocation", flightLocationService.findById(Long.parseLong(toLocation)).getName());
        modelAndView.addObject("departureDate", date1);
        List<Flight> flights = (List<Flight>) flightService.searchFlightOnUser(fromID, toID, date1, total, limit, offset);
        boolean foundFlight = flights.size() > 0;
        modelAndView.addObject("flights", flights);
        modelAndView.addObject("found1", foundFlight);
        if (radio.equals("round")) {
            Date date2 = Date.valueOf(returnDate);
            modelAndView.addObject("returnDate", date2);
            List<Flight> returnFlights = (List<Flight>) flightService.searchFlightOnUser(toID, fromID, date2, total, limit, offset);
            boolean foundReturnFlight = returnFlights.size() > 0;
            modelAndView.addObject("found", foundReturnFlight);
            modelAndView.addObject("returnFlights", returnFlights);
            return modelAndView;
        }
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getOneFlight(@PathVariable("id") long id) {
        return new ResponseEntity<>(flightService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/book")
    public ModelAndView showConfirmBooking(@RequestParam("flightID") String id1, @RequestParam("flight2ID") String id2) {
        ModelAndView modelAndView = new ModelAndView("user/flight-confirm");
        modelAndView.addObject("customer", new Customer());
        if (!id1.equals("undefined")) {
            modelAndView.addObject("flight1", flightService.findById(Long.parseLong(id1)));
        }
        if (!id2.equals("undefined")) {
            modelAndView.addObject("flight2", flightService.findById(Long.parseLong(id2)));
        }
        return modelAndView;
    }
    @PostMapping("/book")
    public ModelAndView bookFlight(Customer customer,
                                   @RequestParam(value = "flight1", required = false) Long flight1,
                                   @RequestParam(value = "flight2", required = false) Long flight2) {
        customerService.save(customer);
        if (flight1 != null) {
            Flight flight = flightService.findById(flight1);
            flightBookingService.save(new FlightBooking(flight, customer));
        }
        if (flight2 != null) {
            Flight flightB = flightService.findById(flight2);
            flightBookingService.save(new FlightBooking(flightB, customer));
        }
        return new ModelAndView("/user/flight-done");
    }
}
