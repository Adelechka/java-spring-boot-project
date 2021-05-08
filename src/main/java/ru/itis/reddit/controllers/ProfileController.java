package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.reddit.model.User;
import ru.itis.reddit.security.details.UserDetailsImpl;
import ru.itis.reddit.services.PostsService;
import ru.itis.reddit.services.UsersService;

@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PostsService postsService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("isAdmin", usersService.getUserByUsername(user.getUsername()).isAdmin());
        model.addAttribute("auth", true);
        model.addAttribute("isProfile", true);
        model.addAttribute("user", usersService.getUserByUsername(user.getUsername()));
        model.addAttribute("posts", postsService.getAllWithLikes(postsService.getAllByAuthorId(usersService.getUserByUsername(user.getUsername()).getId()), usersService.getUserByUsername(user.getUsername()).getId()));
        model.addAttribute("auth_user_id", usersService.getUserByUsername(user.getUsername()).getId());
        model.addAttribute("users_likes", postsService.getAllWithLikes(postsService.getAllThatUserLiked(usersService.getUserByUsername(user.getUsername()).getId()), usersService.getUserByUsername(user.getUsername()).getId()));
        return "profile_page";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/id{user-id}")
    public String getUserPageById(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("user-id") Long userId, Model model) {
        model.addAttribute("isAdmin", usersService.getUserByUsername(user.getUsername()).isAdmin());
        model.addAttribute("auth", true);
        if (usersService.getUserByUsername(user.getUsername()).getId().equals(userId)) {
            model.addAttribute("isProfile", true);
        } else {
            model.addAttribute("isProfile", false);
        }
        model.addAttribute("posts", postsService.getAllWithLikes(postsService.getAllByAuthorId(userId), usersService.getUserByUsername(user.getUsername()).getId()));
        model.addAttribute("user", usersService.getUserByUsername(usersService.getUserById(userId).getLogin()));
        model.addAttribute("auth_user_id", usersService.getUserByUsername(user.getUsername()).getId());
        model.addAttribute("users_likes", postsService.getAllWithLikes(postsService.getAllThatUserLiked(userId), userId));
        return "profile_page";
    }

}
