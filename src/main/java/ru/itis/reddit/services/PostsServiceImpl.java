package ru.itis.reddit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.reddit.dto.PostView;
import ru.itis.reddit.model.Post;
import ru.itis.reddit.repositories.PostsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void savePost(Post post) {
        postsRepository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postsRepository.findAllByOrderByIdAsc();
    }

    @Override
    public List<Post> getAllByAuthorId(Long id) {
        return postsRepository.findAllByAuthorIdOrderByIdAsc(id);
    }

    @Override
    public void likePost(Long userId, Long postId) {
        postsRepository.likePost(postId, userId);
    }

    @Override
    public void dislikePost(Long userId, Long postId) {
        postsRepository.dislikePost(postId, userId);
    }

    @Override
    public Boolean isUserLikedPost(Long userId, Long postId) {
        return postsRepository.isUserLikedPost(userId, postId) != null;
    }

    @Override
    public List<Post> getAllThatUserLiked(Long userId) {
        return postsRepository.findAllThatUserLiked(userId);
    }

    @Override
    public void deletePost(Long id) {
        postsRepository.deleteById(id);
    }

    @Override
    public List<PostView> getAllWithLikes(List<Post> posts, Long userId) {
        List<PostView> postsForHtml = new ArrayList<>();
        for (Post post : posts) {
            PostView currentPost;
            if (this.isUserLikedPost(userId, post.getId())) {
                currentPost = new PostView(post, 1);
            } else {
                currentPost = new PostView(post, 0);
            }
            postsForHtml.add(currentPost);
        }
        return postsForHtml;
    }

    @Override
    public List<PostView> getAllWithoutLikes(List<Post> posts) {
        List<PostView> postsForHtml = new ArrayList<>();
        for (Post post : posts) {
            postsForHtml.add(new PostView(post, 0));
        }
        return postsForHtml;
    }
}
