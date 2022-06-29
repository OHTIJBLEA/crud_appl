package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MyController {
    private final UserService userService;

    @Autowired
    public MyController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", userService.getAllUser());
        return "all-users";
    }

    @GetMapping("/user-save")
    public String saveUserForm(User user) {
        return "user-save";
    }

    @PostMapping("/user-save")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    //    @GetMapping("/user-delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/user-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateEmployee(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}
