package com.frzlyv.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.frzlyv.database.dao.AuthorDao;
import com.frzlyv.database.domain.Author;

/**
 * AuthorDaoImpl
 */
public class AuthorDaoImpl implements AuthorDao {

  private final JdbcTemplate jdbcTemplate;

  public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(Author author) {
    jdbcTemplate.update("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)",
        author.getId(), author.getName(), author.getAge());
  }

}
