package com.travel.controller;

import com.travel.model.Role;
import com.travel.model.User;
import com.travel.service.appuser.AppUserService;
import com.travel.service.role.RoleService;
import com.travel.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @ModelAttribute("currentUser")
    public User userProfile(){
        return appUserService.getCurrentUser();
    }

    @GetMapping("/user")
    public String userPage() {
        return "users/user";
    }

    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("users/register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/addUser")
    public ModelAndView register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("users/register");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("users/login");
        if (user.getRoles() != null){
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
        return modelAndView;
    }

    @GetMapping("/user/edit")
    public ModelAndView showEdit(){
        ModelAndView modelAndView = new ModelAndView("users/edit");
        modelAndView.addObject("currentUser",this.userProfile());
        return modelAndView;
    }

    @PostMapping("/user/edit")
    public String edit(@ModelAttribute User user) throws IOException{
        userService.save(user);
        return "redirect:/user";
    }

    @GetMapping("user/delete")
    public ModelAndView deleteAccount(@RequestParam Long id){
        userService.delete(id);
        return new ModelAndView("redirect:/logout");
    }


}