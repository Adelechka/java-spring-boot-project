package ru.itis.reddit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.reddit.model.Post;
import ru.itis.reddit.repositories.PostsRepository;

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
}
