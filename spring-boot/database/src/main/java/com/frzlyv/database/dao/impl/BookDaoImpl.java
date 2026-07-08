package com.frzlyv.database.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.frzlyv.database.dao.BookDao;
import com.frzlyv.database.domain.Book;

/**
 * BookDaoImpl
 */
@Component
public class BookDaoImpl implements BookDao {

  private final JdbcTemplate jdbcTemplate;

  public BookDaoImpl(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void create(Book book) {
    jdbcTemplate.update("INSERT INTO books (isbn, title, author_id) VALUES (?,?,?)",
        book.getIsbn(), book.getTitle(), book.getAuthorId());
  }

  @Override
  public Optional<Book> findOne(String isbn) {
    List<Book> results = jdbcTemplate.query(
        "SELECT isbn, title, author_id FROM books WHERE isbn = ?",
        new BookRowMapper(),
        isbn);

    return results.stream().findFirst();

  }

  @Override
  public List<Book> find() {
    List<Book> results = jdbcTemplate.query(
        "SELECT isbn, title, author_id FROM books",
        new BookRowMapper());

    return results;
  }

  @Override
  public void update(Book book) {
    jdbcTemplate.update("UPDATE books SET title = ?, author_id = ? WHERE isbn = ?",
        book.getTitle(), book.getAuthorId(), book.getIsbn());
  }

  @Override
  public void delete(String isbn) {
    jdbcTemplate.update("DELETE FROM books WHERE isbn = ?", isbn);
  }

  public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
      return Book
          .builder()
          .isbn(rs.getString("isbn"))
          .title(rs.getString("title"))
          .authorId(rs.getLong("author_id"))
          .build();
    }
  }

}
