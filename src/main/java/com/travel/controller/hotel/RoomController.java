package com.travel.controller.hotel;

import com.travel.model.hotel.Room;
import com.travel.service.hotel.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Service
@RequestMapping("/hotels")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @PostMapping
    public  ResponseEntity<Room> createRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(null,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Room>> allRooms(){
    Iterable<Room> rooms = roomService.findAll();
    return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ModelAndView getAllRooms() {
        ModelAndView mav = new ModelAndView("/hotel/list");
        Iterable<Room> rooms = roomService.findAll();
        mav.addObject("rooms", rooms);
        return mav;
    }
}
