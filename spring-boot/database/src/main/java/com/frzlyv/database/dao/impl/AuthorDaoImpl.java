package com.frzlyv.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.frzlyv.database.dao.AuthorDao;

/**
 * AuthorDaoImpl
 */
public class AuthorDaoImpl implements AuthorDao {

  private final JdbcTemplate jdbcTemplate;

  public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

}
