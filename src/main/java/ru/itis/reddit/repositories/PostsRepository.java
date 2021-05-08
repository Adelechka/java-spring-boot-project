package ru.itis.reddit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.reddit.model.Post;

import javax.transaction.Transactional;
import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByIdAsc();
    List<Post> findAllByAuthorIdOrderByIdAsc(Long authorId);

    @Query(nativeQuery = true, value = "select * from likes where user_id = ?1 and post_id = ?2")
    Object isUserLikedPost(Long userId, Long postId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into likes (post_id, user_id) values (?1, ?2)")
    void likePost(Long postId, Long userId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from likes where post_id = ?1 and user_id = ?2")
    void dislikePost(Long postId, Long userId);

    @Query(nativeQuery = true, value = "select id, text, picture, author_id from post inner join likes l on post.id = l.post_id where l.user_id = ?1")
    List<Post> findAllThatUserLiked(Long userId);
}
