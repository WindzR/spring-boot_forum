package ru.bodins.forum.dao;

import org.springframework.stereotype.Repository;
import ru.bodins.forum.model.Post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PostMem {

    private final List<Post> posts = new ArrayList<>();

    public PostMem() {
        posts.add(Post.of("Hibernate vs Spring Data",
                "Выбираем правильный фреймворк для работы с БД",
                new Date()));
        posts.add(Post.of("Servlet API",
                "Фичи при работе с сервлетами и JSP",
                new Date()));
    }

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> getAll() {
        return posts;
    }

    public Post findById(int id) {
        Post defaultPost = Post.of("default", "default", new Date());
        Optional<Post> rsl = posts.stream().filter(post -> post.getId() == id).findFirst();
        return rsl.orElse(defaultPost);
    }
}
