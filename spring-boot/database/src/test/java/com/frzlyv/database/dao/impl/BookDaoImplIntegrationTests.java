package com.frzlyv.database.dao.impl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.frzlyv.database.TestDataUtil;
import com.frzlyv.database.dao.AuthorDao;
import com.frzlyv.database.domain.Author;
import com.frzlyv.database.domain.Book;

/**
 * BookDaoImplIntegrationTests
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTests {

  private AuthorDao authorDao;
  private BookDaoImpl underTest;

  @Autowired
  public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao authorDao) {
    this.underTest = underTest;
    this.authorDao = authorDao;
  }

  @Test
  public void testThatBookCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    authorDao.create(author);
    Book book = TestDataUtil.createTestBook();
    book.setAuthorId(author.getId());
    underTest.create(book);
    Optional<Book> result = underTest.findOne(book.getIsbn());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(book);
  }

}
