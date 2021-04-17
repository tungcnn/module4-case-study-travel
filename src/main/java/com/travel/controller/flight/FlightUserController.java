package com.travel.controller.flight;

import com.travel.service.flight.serviceinterface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/flights/users/")
public class FlightUserController {
    @Autowired
    private IFlightService flightService;
    @PostMapping("/search")
    public ModelAndView getSearchResult(
            @RequestParam("radio") String radio,
            @RequestParam("fromLocation") String fromLocation,
            @RequestParam("departure") String departureDate,
            @RequestParam("return") String returnDate,
            @RequestParam("adult") String adult,
            @RequestParam("child") String child,
            @RequestParam("toLocation") String toLocation) {

        return new ModelAndView("/flight/list-flight");
    }
}
