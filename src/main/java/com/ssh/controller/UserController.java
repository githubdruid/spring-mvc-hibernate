package com.ssh.controller;

import com.ssh.model.User;
import com.ssh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String userForm(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult result, Model model) {

        if (result.hasErrors()) {

            model.addAttribute("users", userService.list());
            return "userForm";
        }

        userService.save(user);

        return "redirect:/";
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable String id) {

        userService.remove(id);

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id,Model model) {

        model.addAttribute("user",userService.getUser(id));
        return "editForm";
    }
    @PostMapping("/edit/editUser")
    public String editUser(@ModelAttribute("user") @Valid User user,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {

            model.addAttribute("user", user);
            return "editForm";
        }

        userService.edit(user);
        return "redirect:/";
    }
}
