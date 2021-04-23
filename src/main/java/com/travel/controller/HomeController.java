package com.travel.controller;

import com.travel.model.tour.BookTour;
import com.travel.model.tour.Location;
import com.travel.model.tour.Tour;
import com.travel.service.tour.IBookTourService;
import com.travel.service.tour.ILocationService;
import com.travel.service.tour.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ILocationService locationService;

    @Autowired
    private ITourService tourService;

    @Autowired
    private IBookTourService bookTourService;

    @ModelAttribute("location")
    public Page<Location> locations(Pageable pageable) {
        return locationService.findAll(pageable);
    }

    @ModelAttribute("tour")
    public Page<Tour> tours(Pageable pageable) {
        return tourService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("index");
    }

    @GetMapping("search")
    public ModelAndView showAll(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") Double price,
                                @RequestParam("time") String time,Pageable pageable) {
        ModelAndView model = new ModelAndView("tour/tabletour");
        Page<Tour> listAll = tourService.findAllByNameByTimeByPrice(name, description, price, time, pageable);
        model.addObject("tours", listAll);
        return model;
    }

    @GetMapping("bookking")
    public ModelAndView showbook() {
        return new ModelAndView("tour/booking");
    }

    @PostMapping("bookking")
    public ModelAndView createBook(@ModelAttribute BookTour bookTour) {
        bookTourService.save(bookTour);
        ModelAndView model = new ModelAndView("tour/booking");
        model.addObject("booktour", new BookTour());
        return model;
    }
}
