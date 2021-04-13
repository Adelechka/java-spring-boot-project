package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.reddit.security.details.UserDetailsImpl;
import ru.itis.reddit.services.UsersService;

@Controller
public class ManageUsersController {

    @Autowired
    private UsersService usersService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/manageUsers")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("users", usersService.findAllByOrderById());
        return "manage_users_page";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/ban/{id}", method = RequestMethod.POST)
    public String banUser(@PathVariable Long id, Model model) {
        usersService.banById(id);
        return "redirect:/manageUsers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/unban/{id}", method = RequestMethod.POST)
    public String unbanUser(@PathVariable Long id, Model model) {
        usersService.unbanById(id);
        return "redirect:/manageUsers";
    }
}
