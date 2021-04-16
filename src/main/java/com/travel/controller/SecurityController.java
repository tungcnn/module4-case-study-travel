package com.travel.controller;


import com.travel.model.Role;
import com.travel.model.User;
import com.travel.service.role.RoleService;
import com.travel.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public String userPage() {
        return "users/user";
    }

    @GetMapping("/user/home")
    public ModelAndView homeUser() {
        ModelAndView modelAndView = new ModelAndView("users/user");
        return modelAndView;
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "users/admin";
    }

    @GetMapping("/")
    public String homePage() {
        return "users/login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "users/access-denied";
    }


    @PostMapping("/api/register")
    public ResponseEntity<User> create(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Iterable<User> users = userService.findAll();
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        if (user.getRoles() != null) {
            Role role = roleService.findByName("ROLE_ADMIN");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {
            Role role1 = roleService.findByName("ROLE_USER");
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role1);
            user.setRoles(roles1);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
