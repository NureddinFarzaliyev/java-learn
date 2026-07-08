package com.frzlyv.database.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.database.domain.Author;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

  Iterable<Author> ageLessThan(int i);

  @Query("select a from Author a where a.age > ?1")
  Iterable<Author> findThoseWithTheAgeGreaterThan(int i);

}
