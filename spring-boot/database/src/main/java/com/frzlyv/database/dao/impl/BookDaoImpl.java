package com.frzlyv.database.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.frzlyv.database.dao.BookDao;

/**
 * BookDaoImpl
 */
public class BookDaoImpl implements BookDao {

  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

}
