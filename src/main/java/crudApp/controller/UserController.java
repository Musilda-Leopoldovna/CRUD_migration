package crudApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import crudApp.model.entity.User;
import crudApp.model.services.UserService;

@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService userService) {
        this.service = userService;
    }

    @GetMapping("/")
    public String getUsersList(@ModelAttribute User user, Model model,
                               @RequestParam(value = "editId", required = false) Long editId) {
        if (editId != null) {
            User editUser = service.getUserById(editId);
            model.addAttribute("editUser", editUser);
        }
        model.addAttribute("userList", service.getListOfUsers());
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        service.addNewUser(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user) {
        service.changeUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam(value = "deleteId", required = false) Long deleteId) {
        if (deleteId != null) {
            service.removeUserById(deleteId);
        }
        return "redirect:/";
    }
}
