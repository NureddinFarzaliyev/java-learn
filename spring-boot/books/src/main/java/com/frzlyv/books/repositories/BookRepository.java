package com.frzlyv.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.books.domain.entities.BookEntity;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {

}
