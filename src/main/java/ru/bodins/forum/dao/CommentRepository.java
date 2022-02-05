package ru.bodins.forum.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bodins.forum.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
