package ru.itis.reddit.services;

import ru.itis.reddit.model.Comment;

import java.util.List;

public interface CommentsService {
    void saveComment(Comment comment);
    List<Comment> getAllCommentsForPost(Long postId);
    void deleteComment(Long commentId);
    Long getPostIdByCommentId(Long commentId);
}
