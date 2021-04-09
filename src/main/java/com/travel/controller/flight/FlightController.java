package com.travel.controller.flight;

import com.travel.model.flight.Flight;
import com.travel.model.flight.FlightBrand;
import com.travel.service.flight.IFlightBrandService;
import com.travel.service.flight.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private IFlightBrandService flightBrandService;
    @Autowired
    private IFlightService flightService;

    @ModelAttribute("brands")
    public Iterable<FlightBrand> getAllBrand() {
        return flightBrandService.findAll();
    }
    @ModelAttribute("flights")
    public Iterable<Flight> getAllFlights() {
        return flightService.findAll();
    }

    @GetMapping("/ajax")
    public ResponseEntity<Iterable<Flight>> getAllFlightsAjax() {
        return new ResponseEntity<>(flightService.findAll(), HttpStatus.OK);
    }
    @GetMapping
    public ModelAndView showFlightList() {
        return new ModelAndView("/flight/list-flight", "flight", new Flight());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Integer id){
        flightService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
