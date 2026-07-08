package com.frzlyv.database.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

  private Long id;
  private String name;
  private Integer age;

}
