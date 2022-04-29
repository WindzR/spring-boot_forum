package ru.bodins.forum.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import ru.bodins.forum.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    @EntityGraph(attributePaths = "comments")
    Author findAuthorById(int id);

    @EntityGraph(attributePaths = "comments")
    Author findAuthorByName(String name);
}
