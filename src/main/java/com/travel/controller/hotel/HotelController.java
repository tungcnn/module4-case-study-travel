package com.travel.controller.hotel;

import com.travel.model.hotel.Room;
import com.travel.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

//    @GetMapping
//    public ResponseEntity<Iterable<Room>>
}
