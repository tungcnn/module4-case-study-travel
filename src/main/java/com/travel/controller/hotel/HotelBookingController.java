package com.travel.controller.hotel;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users/rooms")
public class HotelBookingController {

    @GetMapping
    public ModelAndView getResult(@RequestParam("location_hotel") String location_hotel,
                                  @RequestParam("name_hotel") String name_hotel,
                                  @RequestParam("departure") String departure) {
        ModelAndView mav = new ModelAndView("/hotel/hotel-result");
        return mav;
    }
}
