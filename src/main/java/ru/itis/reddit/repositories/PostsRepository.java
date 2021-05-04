package ru.itis.reddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.reddit.model.Post;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByIdAsc();
    List<Post> findAllByAuthorIdOrderByIdAsc(Long authorId);
}
