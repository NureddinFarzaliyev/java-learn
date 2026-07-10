package com.frzlyv.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.frzlyv.books.domain.entities.BookEntity;

/**
 * BookService
 */
public interface BookService {

  BookEntity createBook(BookEntity book);

  Page<BookEntity> listAll(Pageable pageable);

  List<BookEntity> listAll();

  Optional<BookEntity> findOne(String isbn);

  Boolean isExists(String isbn);

  BookEntity partialUpdate(String isbn, BookEntity bookEntity);

  void delete(String isbn);
}
