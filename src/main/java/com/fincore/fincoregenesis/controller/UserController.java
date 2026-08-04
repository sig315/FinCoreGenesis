package com.fincore.fincoregenesis.controller;

import com.fincore.fincoregenesis.entity.User;
import com.fincore.fincoregenesis.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        userService.registerUser(user);

        return "register-success";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @GetMapping
    public String showUserList(Model model) {

        model.addAttribute("users", userService.findAllUsers());

        return "user-list";
    }

    @GetMapping("/{id}")
    public String showUserDetail(@PathVariable Long id, Model model) {

        User user = userService.findUserById(id);

        model.addAttribute("user", user);

        return "user-detail";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {

        User user = userService.findUserById(id);

        model.addAttribute("user", user);

        return "user-edit";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable Long id,
                             @Valid User user,
                             BindingResult bindingResult) {

        user.setId(id);

        if (bindingResult.hasErrors()) {
            return "user-edit";
        }

        userService.updateUser(user);

        return "redirect:/users/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "redirect:/users";
    }

}