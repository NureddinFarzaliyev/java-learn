package com.frzlyv.books.services;

import java.util.List;
import java.util.Optional;

import com.frzlyv.books.domain.entities.BookEntity;

/**
 * BookService
 */
public interface BookService {

  BookEntity createBook(BookEntity book);

  List<BookEntity> listAll();

  Optional<BookEntity> findOne(String isbn);

  Boolean isExists(String isbn);

  BookEntity partialUpdate(String isbn, BookEntity bookEntity);
}
