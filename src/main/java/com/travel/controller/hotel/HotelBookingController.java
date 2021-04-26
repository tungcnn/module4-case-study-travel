package com.travel.controller.hotel;

import com.travel.model.hotel.Hotel;
import com.travel.model.hotel.Room;
import com.travel.service.hotel.IHotelService;
import com.travel.service.hotel.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users/rooms")
public class HotelBookingController {

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IHotelService hotelService;

    @ModelAttribute("hotels")
    public Page<Hotel> hotels(Pageable pageable) {
        return hotelService.findAll(pageable);
    }

    @ModelAttribute("rooms")
    public Page<Room> rooms(Pageable pageable) {
        return roomService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView getResult(@RequestParam("location_hotel") String location_hotel,
                                  @RequestParam("name_hotel") String name_hotel,
                                  @RequestParam("departure") String departure1,
                                  @RequestParam(value = "size", defaultValue = "100") int size,
                                  @RequestParam(value = "page", defaultValue = "0") int page) {
        int departure = Integer.parseInt(departure1);
        Iterable<Room> rooms = roomService.findAllByLocationOrName(location_hotel,name_hotel,departure,size,page);
        ModelAndView mav = new ModelAndView("/hotel/hotel-result");
        mav.addObject("rooms", rooms);
        return mav;
    }
}
