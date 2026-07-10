package com.frzlyv.books;

import com.frzlyv.books.domain.dto.AuthorDto;
import com.frzlyv.books.domain.dto.BookDto;
import com.frzlyv.books.domain.entities.AuthorEntity;
import com.frzlyv.books.domain.entities.BookEntity;

/**
 * TestDataUtil
 */
public class TestDataUtil {

  public static AuthorEntity createTestAuthorEntity() {
    return AuthorEntity.builder()
        .age(20)
        .name("John Doe")
        .build();
  }

  public static AuthorDto createTestAuthorDto() {
    return AuthorDto.builder()
        .age(20)
        .name("John Doe")
        .build();
  }

  public static BookEntity createTestBookEntity(AuthorEntity author) {
    return BookEntity.builder()
        .isbn("123-456")
        .title("Test Book")
        .author(author)
        .build();
  }

  public static BookDto createTestBookDto(AuthorDto author) {
    return BookDto.builder()
        .isbn("123-456")
        .title("Test Book")
        .author(author)
        .build();
  }

}
