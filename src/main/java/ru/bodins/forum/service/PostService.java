package ru.bodins.forum.service;

import org.springframework.stereotype.Service;
import ru.bodins.forum.dao.PostRepository;
import ru.bodins.forum.exception.PostNotFoundException;
import ru.bodins.forum.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final Post defaultPost = Post.of("default", "default", new Date());

    private final PostRepository dao;

    public PostService(PostRepository dao) {
        this.dao = dao;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        dao.findAll().forEach(rsl::add);
        return rsl;
    }

    public void savePost(Post post) {
        dao.save(post);
    }

    public Post findPostById(int id) {
        Optional<Post> post = dao.findPostById(id);
        try {
            if (post.isEmpty()) {
                throw new PostNotFoundException("Post with such ID not FOUND!");
            }
            return post.get();
        } catch (PostNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("PostNotFoundException in PostService.findPostById(id)");
        }
        return post.orElse(defaultPost);
    }
}
