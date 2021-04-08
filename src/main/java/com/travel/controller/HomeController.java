package com.travel.controller;

import com.travel.model.tour.Tour;
import com.travel.service.tour.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @Autowired
    private TourServiceImpl tourService;

    @GetMapping("/")
    public ModelAndView getHomePage() {
        return new ModelAndView("/index");
    }

    @GetMapping("/tours")
    public ModelAndView showTours() {
        ModelAndView modelAndView = new ModelAndView("tour/list");
        modelAndView.addObject("tours", tourService.findAll());
        return modelAndView;
    }
}
