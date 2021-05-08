package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.reddit.security.details.UserDetailsImpl;
import ru.itis.reddit.services.CommentsService;
import ru.itis.reddit.services.PostsService;
import ru.itis.reddit.services.UsersService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LikesController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;


    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/like_post{post-id}")
    public String likePost(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("post-id") Long postId, HttpServletRequest request) {
        String page;
        if (request.getHeader("referer").split("/").length == 4) {
            page = request.getHeader("referer").split("/")[3];
        } else {
            page = "";
        }
        postsService.likePost(usersService.getUserByUsername(user.getUsername()).getId(), postId);
        return "redirect:/" + page;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/dislike_post{post-id}")
    public String dislikePost(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("post-id") Long postId, HttpServletRequest request) {
        String page;
        if (request.getHeader("referer").split("/").length == 4) {
            page = request.getHeader("referer").split("/")[3];
        } else {
            page = "";
        }
        postsService.dislikePost(usersService.getUserByUsername(user.getUsername()).getId(), postId);
        return  "redirect:/" + page;
    }

}
