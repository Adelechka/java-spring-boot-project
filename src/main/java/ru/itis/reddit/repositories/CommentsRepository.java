package ru.itis.reddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.reddit.model.Comment;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
}
