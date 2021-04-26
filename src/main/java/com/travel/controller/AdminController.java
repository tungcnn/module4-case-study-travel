package com.travel.controller;

import com.travel.model.User;
import com.travel.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private IUserService userService;

    @GetMapping("admin/listUser")
    public ModelAndView showAllUsers(@PageableDefault(size = 7) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("users/admin");
        modelAndView.addObject("users", userService.findAll(pageable));
        return modelAndView;
    }


//
//    @GetMapping
//    public ResponseEntity<Iterable<User>> getAllUser(){
//        Iterable<User> users = userService.findAll();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<User> saveUser(@RequestBody User user){
//        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id){
//        Optional<User> userOptional = userService.findById(id);
//        if (userOptional.isPresent()){
//            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
//        Optional<User> userOptional = userService.findById(id);
//        if (userOptional.isPresent()) {
//            user.setId(userOptional.get().getId());
//            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<User> deleteUser(@PathVariable Long id){
//        Optional<User> userOptional = userService.findById(id);
//        if (userOptional.isPresent()){
//            userService.delete(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
