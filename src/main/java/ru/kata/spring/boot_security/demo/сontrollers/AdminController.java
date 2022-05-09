package ru.kata.spring.boot_security.demo.сontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping()
    public String allUsers(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user,Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("user", userService.getUserByUsername(user.getUsername()));
        model.addAttribute("users", userService.allUsers());
        return "admin";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        userService.newUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("editUser") User user) {
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/show")
    public String showAdminProfile(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user,Model model){
        model.addAttribute("user", userService.getUserByUsername(user.getUsername()));
        model.addAttribute("roles", roleService.getRoles());
        return "show";
    }
}