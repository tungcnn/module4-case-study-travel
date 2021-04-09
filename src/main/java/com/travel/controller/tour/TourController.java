package com.travel.controller.tour;

import com.travel.model.tour.Location;
import com.travel.model.tour.Tour;
import com.travel.service.tour.LocationService;
import com.travel.service.tour.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("tours")
public class TourController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private TourServiceImpl tourService;

    @ModelAttribute("locations")
    public Iterable<Location> locations() {
        return locationService.findAll();
    }


    @PostMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTour(@RequestBody Tour tour) {
        tourService.save(tour);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public Iterable<Tour> showTours() {
        return tourService.findAll();
    }

    @GetMapping
    public ModelAndView showLisTours() {
        ModelAndView modelAndView = new ModelAndView("tour/list-tour");
        modelAndView.addObject("tours", showTours());
        return modelAndView;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
