package ru.bodins.forum.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bodins.forum.model.Post;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Optional<Post> findPostById(int id);
}
