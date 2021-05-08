package ru.itis.reddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.reddit.model.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPost_IdOrderById(Long postId);

    @Query(nativeQuery = true, value = "select post_id from comment where id = ?1")
    Long getPostIdByCommentId(Long commentId);
}
