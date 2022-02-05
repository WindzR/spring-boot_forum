package ru.bodins.forum.service;

import org.springframework.stereotype.Service;
import ru.bodins.forum.dao.AuthorRepository;
import ru.bodins.forum.dao.PostRepository;
import ru.bodins.forum.exception.PostNotFoundException;
import ru.bodins.forum.model.Author;
import ru.bodins.forum.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final Post defaultPost = Post.of("default", "default", new Date());

    private final PostRepository postDAO;

    private final AuthorRepository authorDAO;

    public PostService(PostRepository postDAO, AuthorRepository authorDAO) {
        this.postDAO = postDAO;
        this.authorDAO = authorDAO;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        postDAO.findAll().forEach(rsl::add);
        return rsl;
    }

    public void savePost(Post post) {
        postDAO.save(post);
    }

    public Post findPostById(int id) {
        Optional<Post> post = postDAO.findPostById(id);
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

    public Author findAuthorById(int id) {
        return authorDAO.findAuthorById(id);
    }
}
