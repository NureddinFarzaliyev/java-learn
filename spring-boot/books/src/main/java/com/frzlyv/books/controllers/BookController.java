package com.frzlyv.books.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    Boolean exists = bookService.isExists(isbn);
    BookEntity bookEntity = bookMapper.toEntity(bodyBook);
    BookEntity savedBookEntity = bookService.createBook(bookEntity);
    BookDto responseBook = bookMapper.toDto(savedBookEntity);
    if (exists) {
      return new ResponseEntity<>(responseBook, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(responseBook, HttpStatus.CREATED);
    }
  }

  @GetMapping("/books")
  public List<BookDto> listBooks() {
    List<BookEntity> bookEntities = bookService.listAll();
    return bookEntities.stream()
        .map(bookMapper::toDto)
        .collect(Collectors.toList());
  }

  @GetMapping("/books/{isbn}")
  public ResponseEntity<BookDto> findOneBook(@PathVariable String isbn) {
    return bookService.findOne(isbn)
        .map(bookMapper::toDto)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PatchMapping(path = "/books/{isbn}")
  public ResponseEntity<BookDto> partialUpdateBook(
      @PathVariable("isbn") String isbn,
      @RequestBody BookDto bookDto) {
    if (!bookService.isExists(isbn)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    BookEntity bookEntity = bookMapper.toEntity(bookDto);
    BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);
    return new ResponseEntity<>(
        bookMapper.toDto(updatedBookEntity),
        HttpStatus.OK);
  }
}
