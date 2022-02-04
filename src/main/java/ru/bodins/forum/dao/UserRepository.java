package ru.bodins.forum.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bodins.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findDistinctByUsernameLike(String username);
}
