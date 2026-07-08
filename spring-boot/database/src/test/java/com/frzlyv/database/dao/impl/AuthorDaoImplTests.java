package com.frzlyv.database.dao.impl;

import static org.mockito.Mockito.verify;

import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.frzlyv.database.TestDataUtil;
import com.frzlyv.database.domain.Author;

/**
 * AuthorDaoImplTests
 */
@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private AuthorDaoImpl underTest;

  @Test
  public void testThatCreateAuthorGeneratesCorrectSql() {
    Author author = TestDataUtil.createTestAuthor();

    underTest.create(author);

    verify(jdbcTemplate).update(eq("INSERT INTO authors (id, name, age) VALUES (?, ?, ?)"),
        eq(author.getId()), eq(author.getName()), eq(author.getAge()));

  }

  @Test
  public void testThatFindOneAuthorGeneratesCorrectSql() {
    underTest.findOne(1L);

    verify(jdbcTemplate).query(
        eq("SELECT id, name, age FROM authors WHERE id = ? LIMIT 1"),
        ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any(),
        eq(1L));

  }

  @Test
  public void testThatFindManyAuthorGeneratesCorrectSql() {
    underTest.find();

    verify(jdbcTemplate).query(
        eq("SELECT id, name, age FROM authors"),
        ArgumentMatchers.<AuthorDaoImpl.AuthorRowMapper>any());
  }

}
