package com.frzlyv.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.database.domain.Author;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
