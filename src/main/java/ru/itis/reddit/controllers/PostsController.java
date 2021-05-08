package ru.itis.reddit.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.reddit.dto.CommentDto;
import ru.itis.reddit.model.Comment;
import ru.itis.reddit.model.Post;
import ru.itis.reddit.security.details.UserDetailsImpl;
import ru.itis.reddit.services.CommentsService;
import ru.itis.reddit.services.PostsService;
import ru.itis.reddit.services.UsersService;
import ru.itis.reddit.utils.FileUploadUtil;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

@Controller
public class PostsController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Value("${path.post-photo}")
    private String postPhotoPath;


    @Value("${path.post-photo-for-html}")
    private String postPhotoPathForHtml;

    @PermitAll
    @GetMapping("/")
    public String getIndexPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        if (user != null) {
            model.addAttribute("isAdmin", usersService.getUserByUsername(user.getUsername()).isAdmin());
            model.addAttribute("auth", true);
            model.addAttribute("user", usersService.getUserByUsername(user.getUsername()));
            model.addAttribute("posts", postsService.getAllWithLikes(postsService.getAll(), usersService.getUserByUsername(user.getUsername()).getId()));
            model.addAttribute("auth_user_id", usersService.getUserByUsername(user.getUsername()).getId());
        } else {
            model.addAttribute("isAdmin", false);
            model.addAttribute("auth", false);
            model.addAttribute("posts", postsService.getAllWithoutLikes(postsService.getAll()));
        }
        return "index";
    }

    @PermitAll
    @GetMapping(value = "/post_id{post-id}")
    public String getPost(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("post-id") Long postId, Model model) {
        if (user != null) {
            model.addAttribute("postId", postId);
            model.addAttribute("isAdmin", usersService.getUserByUsername(user.getUsername()).isAdmin());
            model.addAttribute("auth", true);
            model.addAttribute("user", usersService.getUserByUsername(user.getUsername()));
            model.addAttribute("posts", postsService.getAllWithLikes(postsService.getPostsById(postId), usersService.getUserByUsername(user.getUsername()).getId()));
            model.addAttribute("auth_user_id", usersService.getUserByUsername(user.getUsername()).getId());
        } else {
            model.addAttribute("isAdmin", false);
            model.addAttribute("auth", false);
            model.addAttribute("posts", postsService.getAllWithoutLikes(postsService.getPostsById(postId)));
        }
        model.addAttribute("comment_for_post", commentsService.getAllCommentsForPost(postId));
        return "post_page";
    }


    @SneakyThrows
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/post/{user-id}")
    public String savePost(@PathVariable("user-id") Long userId, Post post, @RequestParam("photo") MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "."
                    + StringUtils.cleanPath((Objects.requireNonNull(multipartFile.getOriginalFilename())).split("\\.")[1]);
            post.setPicture(postPhotoPathForHtml + fileName);
            post.setAuthor(usersService.getUserById(userId));
            postsService.savePost(post);

            String uploadDir = postPhotoPath + post.getId();
            fileUploadUtil.saveFile(uploadDir, postPhotoPath + fileName, multipartFile);
        } else {
            post.setAuthor(usersService.getUserById(userId));
            postsService.savePost(post);
        }
        return "redirect:/profile";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/delete_post{post-id}")
    public String deletePost(@PathVariable("post-id") Long postId, HttpServletRequest request) {
        postsService.deletePost(postId);
        String page;
        if (request.getHeader("referer").split("/").length == 4) {
            if (request.getHeader("referer").contains("post_id")) {
                page = "";
            } else {
                page = request.getHeader("referer").split("/")[3];
            }
        } else {
            page = "";
        }
        return "redirect:/" + page;
    }

}
