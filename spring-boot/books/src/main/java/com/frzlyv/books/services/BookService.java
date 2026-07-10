package com.frzlyv.books.services;

import java.util.List;

import com.frzlyv.books.domain.entities.BookEntity;

/**
 * BookService
 */
public interface BookService {

  BookEntity createBook(BookEntity book);

  List<BookEntity> listAll();

}
