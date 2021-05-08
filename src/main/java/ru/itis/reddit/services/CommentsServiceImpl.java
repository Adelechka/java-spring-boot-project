package ru.itis.reddit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.reddit.model.Comment;
import ru.itis.reddit.repositories.CommentsRepository;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public void saveComment(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public List<Comment> getAllCommentsForPost(Long postId) {
        return commentsRepository.findAllByPost_IdOrderById(postId);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentsRepository.delete(commentsRepository.getOne(commentId));
    }

    @Override
    public Long getPostIdByCommentId(Long commentId) {
        return commentsRepository.getPostIdByCommentId(commentId);
    }
}
