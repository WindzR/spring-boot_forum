package ru.bodins.forum.dao;

import org.springframework.data.repository.CrudRepository;
import ru.bodins.forum.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
