package io.bootify.amenity_reservation_system.controller;

import io.bootify.amenity_reservation_system.model.User;
import io.bootify.amenity_reservation_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/reservations")
    public String reservations(Model model) {
        User user = userService.get((long) 10000);
        model.addAttribute("user", user);

        return "reservations";
    }
}