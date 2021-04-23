package com.travel.controller.flight;

import com.travel.exception.NotFoundException;
import com.travel.model.flight.Flight;
import com.travel.model.flight.FlightBrand;
import com.travel.model.flight.FlightLocation;
import com.travel.service.flight.serviceinterface.IFlightBrandService;
import com.travel.service.flight.serviceinterface.IFlightLocationService;
import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
public class FlightController {
    @Autowired
    private IFlightBrandService flightBrandService;
    @Autowired
    private IFlightService flightService;
    @Autowired
    private IFlightLocationService flightLocationService;
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showNotFound() {
        return new ModelAndView("error404");
    }

    @ModelAttribute("brands")
    public Page<FlightBrand> getAllBrand(Pageable pageable) {
        return flightBrandService.findAll(pageable);
    }
    @ModelAttribute("flights")
    public Page<Flight> getAllFlights(Pageable pageable) {
        return flightService.findAll(pageable);
    }
    @ModelAttribute("locations")
    public Page<FlightLocation> getAllLocation(Pageable pageable) {
        return flightLocationService.findAll(pageable);
    }
    @ModelAttribute("pages")
    public int[] getPages(Pageable pageable) {
        int totalPages = flightService.findAll(pageable).getTotalPages();
        int[] pages = new int[totalPages];
        for (int i = 0; i < totalPages ; i++) {
            pages[i] = i;
        }
        return pages;
    }

    @GetMapping("/flights/ajax")
    public ResponseEntity<Page<Flight>> getAllFlightsAjax(@RequestParam(required = false) String q, Pageable pageable) {
        Page<Flight> flights;
        if (q != null) {
            flights = flightService.search(q, pageable);
        } else {
            flights = flightService.findAll(pageable);
        }
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
    @GetMapping("/flights")
    public ModelAndView showFlightList() {
        return new ModelAndView("/flight/list-flight", "flight", new Flight());
    }
    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable("id") long id) {
        return new ResponseEntity<>(flightService.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/flights", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        flight.setCode(flight.getFlightBrand().getCode() + flight.getId());
        flightService.save(flight);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
    @PutMapping(value = "/flights", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editFlight(@RequestBody Flight flight) {
        flightService.save(flight);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Integer id){
        flightService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
