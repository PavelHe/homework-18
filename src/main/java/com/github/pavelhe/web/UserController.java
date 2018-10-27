package com.github.pavelhe.web;

import com.github.pavelhe.model.*;
import com.github.pavelhe.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping({"/user", "/"})
    public String getAll(Model model) {
        model.addAttribute("userList", service.findAll());
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/user/add")
    public String createUser(@ModelAttribute User user, Model model) {
        int userSaveCode = service.save(user);

        if (userSaveCode == UserService.USER_EXIST) {
            model.addAttribute("userExist", "User already exist!");
            model.addAttribute("userList", service.findAll());
            model.addAttribute("user", new User());
            return "index";
        }

        return "redirect:/";
    }
}
