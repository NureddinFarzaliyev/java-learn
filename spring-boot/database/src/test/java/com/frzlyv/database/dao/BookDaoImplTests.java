package com.frzlyv.database.dao;

import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import com.frzlyv.database.dao.impl.BookDaoImpl;
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
  public void testThatCreateAuthorGeneratesCorrectSql() {
    Book book = Book
        .builder()
        .isbn("123-456")
        .title("Test Book")
        .authorId(1L)
        .build();

    underTest.create(book);

    verify(jdbcTemplate).update(eq("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)"),
        eq(book.getIsbn()), eq(book.getTitle()), eq(book.getAuthorId()));

  }

}
