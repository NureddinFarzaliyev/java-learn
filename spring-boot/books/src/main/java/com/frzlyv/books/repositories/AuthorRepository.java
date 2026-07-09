package com.frzlyv.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.books.domain.entities.AuthorEntity;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, Long> {

}
