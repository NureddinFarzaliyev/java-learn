package com.frzlyv.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.books.domain.entities.BookEntity;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {

}
