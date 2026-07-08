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
import com.frzlyv.database.domain.Book;

/**
 * AuthorDaoImplTests
 */
@ExtendWith(MockitoExtension.class)
public class BookDaoImplTests {

  @Mock
  private JdbcTemplate jdbcTemplate;

  @InjectMocks
  private BookDaoImpl underTest;

  @Test
  public void testThatCreateBookGeneratesCorrectSql() {
    Book book = TestDataUtil.createTestBook();

    underTest.create(book);

    verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)"),
        eq(book.getIsbn()), eq(book.getTitle()), eq(book.getAuthorId()));

  }

  @Test
  public void testThatFindOneBookGeneratesCorrectSql() {
    underTest.findOne("123-456");

    verify(jdbcTemplate).query(
        eq("SELECT isbn, title, author_id FROM books WHERE isbn = ?"),
        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
        eq("123-456"));
  }

  @Test
  public void testThatFindManyBookGeneratesCorrectSql() {
    underTest.find();

    verify(jdbcTemplate).query(
        eq("SELECT isbn, title, author_id FROM books"),
        ArgumentMatchers.<BookDaoImpl.BookRowMapper>any());
  }

}
