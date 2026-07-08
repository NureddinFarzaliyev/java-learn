package com.frzlyv.database.dao;

import java.util.List;
import java.util.Optional;

import com.frzlyv.database.domain.Book;

/**
 * BookDao
 */
public interface BookDao {

  void create(Book book);

  Optional<Book> findOne(String isbn);

  List<Book> find();

  void update(Book book);

}
