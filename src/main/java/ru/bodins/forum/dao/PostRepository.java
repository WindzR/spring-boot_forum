package ru.bodins.forum.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bodins.forum.model.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @EntityGraph(attributePaths = {"comments"})
    List<Post> findAll();

    @EntityGraph(attributePaths = {"comments"})
    Optional<Post> findPostById(int id);
}
