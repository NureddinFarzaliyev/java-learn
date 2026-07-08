package com.frzlyv.database.dao;

import java.util.List;
import java.util.Optional;

import com.frzlyv.database.domain.Book;

/**
 * BookDao
 */
public interface BookDao {

  public void create(Book book);

  public Optional<Book> findOne(String isbn);

  public List<Book> find();

}
