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
        .id(1L)
        .name("John Doe")
        .age(20)
        .build();
  }

  public static Author createTestAuthor2() {
    return Author
        .builder()
        .id(2L)
        .name("Alex Doe")
        .age(30)
        .build();
  }

  public static Book createTestBook() {
    return Book
        .builder()
        .isbn("123-456")
        .title("Test Book")
        .authorId(1L)
        .build();
  }

  public static Book createTestBook2() {
    return Book
        .builder()
        .isbn("321-654")
        .title("Test Book 2")
        .authorId(1L)
        .build();
  }
}
