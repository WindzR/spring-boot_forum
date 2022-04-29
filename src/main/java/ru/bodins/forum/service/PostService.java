package ru.bodins.forum.service;

import org.springframework.stereotype.Service;
import ru.bodins.forum.dao.AuthorRepository;
import ru.bodins.forum.dao.CommentRepository;
import ru.bodins.forum.dao.PostRepository;
import ru.bodins.forum.exception.PostNotFoundException;
import ru.bodins.forum.model.Author;
import ru.bodins.forum.model.Comment;
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

    private final CommentRepository commentDAO;

    public PostService(PostRepository postDAO, AuthorRepository authorDAO,
                       CommentRepository commentDAO) {
        this.postDAO = postDAO;
        this.authorDAO = authorDAO;
        this.commentDAO = commentDAO;
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

    public Author findAuthorByName(String name) {
        return authorDAO.findAuthorByName(name);
    }

    public void saveComment(Comment comment) {
        commentDAO.save(comment);
    }
}
