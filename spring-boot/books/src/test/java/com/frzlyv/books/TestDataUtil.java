package com.frzlyv.books;

import com.frzlyv.books.domain.entities.AuthorEntity;

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

}
