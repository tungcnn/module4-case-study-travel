package com.travel.controller.tour;

import com.travel.model.tour.Location;
import com.travel.model.tour.Tour;
import com.travel.service.tour.LocationService;
import com.travel.service.tour.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("tours")
public class TourController {
    private final LocationService locationService;

    private final TourServiceImpl tourService;

    @Autowired
    public TourController(LocationService locationService, TourServiceImpl tourService) {
        this.locationService = locationService;
        this.tourService = tourService;
    }

    @ModelAttribute("locations")
    public Page<Location> locations(Pageable pageable) {
        return locationService.findAll(pageable);
    }


    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTour(@RequestBody Tour tour) {
        tourService.save(tour);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("list")
    public ResponseEntity<Page<Tour>> showTours(@RequestParam(required = false) String t, Pageable pageable) {
        Page<Tour> tour;
        if (t != null) {
            tour = tourService.findByName(t, pageable);
        } else {
            tour = tourService.findAll(pageable);
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @GetMapping()
    public ModelAndView showLisTours(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("tour/list-tour");
        modelAndView.addObject("tours", tourService.findAll(pageable));
        return modelAndView;
    }

    @ModelAttribute("pages")
    public int[] getPages(Pageable pageable) {
        int totalPages = tourService.findAll(pageable).getTotalPages();
        int[] pages = new int[totalPages];
        for (int i = 0; i < totalPages; i++) {
            pages[i] = i;
        }
        return pages;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Long id) {
        tourService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editTour(@RequestBody Tour tour) {
        tourService.save(tour);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Tour> findTourId(@PathVariable Long id) {
        return new ResponseEntity<>(tourService.findById(id), HttpStatus.OK);
    }
}
