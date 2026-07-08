package com.frzlyv.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

  private String isbn;
  private String title;
  private Long authorId;

}
