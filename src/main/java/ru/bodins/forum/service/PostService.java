package ru.bodins.forum.service;

import org.springframework.stereotype.Service;
import ru.bodins.forum.dao.PostMem;
import ru.bodins.forum.exception.PostNotFoundException;
import ru.bodins.forum.model.Post;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostMem dao;

    public PostService(PostMem dao) {
        this.dao = dao;
    }

    public List<Post> getAll() {
        return dao.getAll();
    }

    public void savePost(Post post) {
        dao.save(post);
    }

    public Post findPostById(int id) {
        try {
            Post rsl = dao.findById(id);
            if (rsl.getName().equals("default")) {
                throw new PostNotFoundException("Post with such ID not FOUND!");
            }
            return rsl;
        } catch (PostNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Post with such ID not FOUND!");
        }
        return new Post();
    }
}
