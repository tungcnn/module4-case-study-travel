package com.travel.controller.flight;

import com.travel.model.flight.Flight;
import com.travel.model.flight.FlightBrand;
import com.travel.model.flight.FlightLocation;
import com.travel.service.flight.IFlightBrandService;
import com.travel.service.flight.IFlightLocationService;
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
    @Autowired
    private IFlightLocationService flightLocationService;

    @ModelAttribute("brands")
    public Iterable<FlightBrand> getAllBrand() {
        return flightBrandService.findAll();
    }
    @ModelAttribute("flights")
    public Iterable<Flight> getAllFlights() {
        return flightService.findAll();
    }
    @ModelAttribute("locations")
    public Iterable<FlightLocation> getAllLocation() {
        return flightLocationService.findAll();
    }

    @GetMapping("/ajax")
    public ResponseEntity<Iterable<Flight>> getAllFlightsAjax() {
        return new ResponseEntity<>(flightService.findAll(), HttpStatus.OK);
    }
    @GetMapping
    public ModelAndView showFlightList() {
        return new ModelAndView("/flight/list-flight", "flight", new Flight());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable("id") long id) {
        return new ResponseEntity<>(flightService.findById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Integer id){
        flightService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
