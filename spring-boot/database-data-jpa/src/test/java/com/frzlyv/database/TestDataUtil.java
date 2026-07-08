package com.frzlyv.database;

import com.frzlyv.database.domain.Author;
import com.frzlyv.database.domain.Book;

/**
 * TestDataUtil
 */
public class TestDataUtil {

  private TestDataUtil() {
  }

  public static Author createTestAuthor() {
    return Author
        .builder()
        .name("John Doe")
        .age(20)
        .build();
  }

  public static Author createTestAuthor2() {
    return Author
        .builder()
        .name("Alex Doe")
        .age(30)
        .build();
  }

  public static Book createTestBook(Author author) {
    return Book
        .builder()
        .isbn("123-456")
        .title("Test Book")
        .author(author)
        .build();
  }

  public static Book createTestBook2(Author author) {
    return Book
        .builder()
        .isbn("321-654")
        .title("Test Book 2")
        .author(author)
        .build();
  }
}
