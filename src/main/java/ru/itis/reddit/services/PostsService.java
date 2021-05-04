package ru.itis.reddit.services;

import ru.itis.reddit.model.Post;

import java.util.List;

public interface PostsService {
    void savePost(Post post);
    List<Post> getAll();
    List<Post> getAllByAuthorId(Long id);
}
