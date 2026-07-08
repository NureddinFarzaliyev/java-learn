package com.frzlyv.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.database.domain.Book;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

}
