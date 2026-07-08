package com.frzlyv.database.dao;

import java.util.Optional;

import com.frzlyv.database.domain.Author;

/**
 * AuthorDao
 */
public interface AuthorDao {

  void create(Author author);

  Optional<Author> findOne(Long id);

}
