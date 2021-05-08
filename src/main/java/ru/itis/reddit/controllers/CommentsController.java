package ru.itis.reddit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.reddit.dto.CommentDto;
import ru.itis.reddit.model.Comment;
import ru.itis.reddit.security.details.UserDetailsImpl;
import ru.itis.reddit.services.CommentsService;
import ru.itis.reddit.services.PostsService;
import ru.itis.reddit.services.UsersService;


@Controller
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/post/comment_post{post-id}")
    public String commentPost(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("post-id") Long postId, CommentDto commentDto) {
        Comment comment = Comment
                .builder()
                .text(commentDto.getText())
                .post(postsService.getPostById(postId))
                .author(usersService.getUserByUsername(user.getUsername()))
                .build();
        commentsService.saveComment(comment);
        return "redirect:/post_id" + postId;
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/delete_comment{comment-id}")
    public String deleteComment(@PathVariable("comment-id") Long commentId) {
        Long postId = commentsService.getPostIdByCommentId(commentId);
        commentsService.deleteComment(commentId);
        return "redirect:/post_id" + postId;
    }

}
