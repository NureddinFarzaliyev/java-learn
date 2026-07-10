package com.frzlyv.books.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frzlyv.books.domain.dto.BookDto;
import com.frzlyv.books.domain.entities.BookEntity;
import com.frzlyv.books.mappers.Mapper;
import com.frzlyv.books.services.BookService;

/**
 * BookController
 */
@RestController
public class BookController {

  private Mapper<BookEntity, BookDto> bookMapper;
  private BookService bookService;

  public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
    this.bookMapper = bookMapper;
    this.bookService = bookService;
  }

  @PutMapping("/books/{isbn}")
  public ResponseEntity<BookDto> createAuthor(@PathVariable("isbn") String isbn, @RequestBody BookDto bodyBook) {
    BookEntity bookEntity = bookMapper.toEntity(bodyBook);
    BookEntity savedBookEntity = bookService.createBook(bookEntity);
    BookDto responseBook = bookMapper.toDto(savedBookEntity);
    return new ResponseEntity<>(responseBook, HttpStatus.CREATED);

  }

}
