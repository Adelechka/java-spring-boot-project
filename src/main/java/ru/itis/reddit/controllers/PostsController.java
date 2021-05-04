package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.reddit.model.Post;
import ru.itis.reddit.services.PostsService;
import ru.itis.reddit.services.UsersService;

import javax.annotation.security.PermitAll;

@Controller
public class PostsController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;

    @PermitAll
    @GetMapping("/")
    public String getSignInPage(Model model) {
        model.addAttribute("posts", postsService.getAll());
        return "index";
    }

    @PostMapping(value = "/post/{user-id}")
    public String savePost(@PathVariable("user-id") Long userId, Post post) {
        Post newPost = Post.builder()
                .author(usersService.getUserById(userId))
                .text(post.getText())
                .build();
        postsService.savePost(newPost);
        return "redirect:/profile";
    }
}
