package com.example.app.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public String show(Model model) {
        model.addAttribute("user", "I'm a user!");
        return "user/show";
    }
}
