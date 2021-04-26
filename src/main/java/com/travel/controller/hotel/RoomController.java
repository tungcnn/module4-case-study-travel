package com.travel.controller.hotel;

import com.travel.exception.NotFoundException;
import com.travel.model.hotel.Hotel;
import com.travel.model.hotel.Room;
import com.travel.service.hotel.IHotelService;
import com.travel.service.hotel.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Service
@RequestMapping("/admin/rooms")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @Autowired
    private IHotelService hotelService;

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showNotFound() {
        return new ModelAndView("error404");
    }

    @ModelAttribute("hotels")
    public Page<Hotel> hotels(Pageable pageable) {
        return hotelService.findAll(pageable);
    }

    @ModelAttribute("rooms")
    public Page<Room> rooms(Pageable pageable) {
        return roomService.findAll(pageable);
    }

    @ModelAttribute("pages")
    public int[] getPages(Pageable pageable) {
        int totalPages = roomService.findAll(pageable).getTotalPages();
        int[] pages = new int[totalPages];
        for (int i = 0; i < totalPages; i++) {
            pages[i] = i;
        }
        return pages;
    }

    @GetMapping("/ajax")
    public ResponseEntity<Page<Room>> allRooms(@RequestParam(required = false) String q, Pageable pageable){
        Page<Room> rooms;
        if (q != null) {
            rooms = roomService.findAllByTypeContaining(q, pageable);
        } else {
            rooms = roomService.findAll(pageable);
        }
    return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping
    public ModelAndView getAllRooms(Pageable pageable) {
        ModelAndView mav = new ModelAndView("list-room");
        Page<Room> rooms = roomService.findAll(pageable);
        mav.addObject("rooms", rooms);
        return mav;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable("id") long id) {
        return new ResponseEntity<>(roomService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> editRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") long id) {
        roomService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
