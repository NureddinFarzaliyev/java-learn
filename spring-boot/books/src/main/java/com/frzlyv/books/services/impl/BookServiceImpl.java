package com.frzlyv.books.services.impl;

import java.util.List;
import java.util.Optional;

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

  @Override
  public Optional<BookEntity> findOne(String isbn) {
    return bookRepository.findById(isbn);
  }

  @Override
  public Boolean isExists(String isbn) {
    return bookRepository.existsById(isbn);
  }

  @Override
  public BookEntity partialUpdate(String isbn, BookEntity bookEntity) {
    bookEntity.setIsbn(isbn);

    return bookRepository.findById(isbn).map(existingBook -> {
      Optional.ofNullable(bookEntity.getTitle()).ifPresent(existingBook::setTitle);
      return bookRepository.save(existingBook);
    }).orElseThrow(() -> new RuntimeException("Book does not exist"));
  }

  @Override
  public void delete(String isbn) {
    bookRepository.deleteById(isbn);
  }
}
