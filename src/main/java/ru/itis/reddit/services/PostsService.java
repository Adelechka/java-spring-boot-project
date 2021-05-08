package ru.itis.reddit.services;

import ru.itis.reddit.dto.PostView;
import ru.itis.reddit.model.Post;

import java.util.List;

public interface PostsService {
    void savePost(Post post);
    List<Post> getAll();
    List<Post> getAllByAuthorId(Long id);
    void likePost(Long userId, Long postId);
    void dislikePost(Long userId, Long postId);
    Boolean isUserLikedPost(Long userId, Long postId);
    List<Post> getAllThatUserLiked(Long userId);
    void deletePost(Long id);
    List<PostView> getAllWithLikes(List<Post> posts, Long userId);
    List<PostView> getAllWithoutLikes(List<Post> posts);
}
