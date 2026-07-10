package com.frzlyv.books;

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

  public static BookEntity createTestBookEntity() {
    return BookEntity.builder()
        .isbn("123-456")
        .title("Test Book")
        .build();
  }

}
