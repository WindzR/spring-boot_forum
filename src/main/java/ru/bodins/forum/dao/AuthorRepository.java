package ru.bodins.forum.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bodins.forum.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Author findAuthorById(int id);
}
