package com.frzlyv.books.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frzlyv.books.domain.entities.BookEntity;
import com.frzlyv.books.repositories.BookRepository;
import com.frzlyv.books.services.BookService;

/**
 * BookServiceImpl
 */
@Service
public class BookServiceImpl implements BookService {

  private BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public BookEntity createBook(BookEntity book) {
    return bookRepository.save(book);
  }

  @Override
  public List<BookEntity> listAll() {
    return bookRepository.findAll();
  }

}
