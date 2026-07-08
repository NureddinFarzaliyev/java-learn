package com.frzlyv.database.repositories;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.frzlyv.database.TestDataUtil;
import com.frzlyv.database.domain.Author;
import com.frzlyv.database.domain.Book;

/**
 * BookDaoImplIntegrationTests
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTests {

  private AuthorRepository authorRepository;
  private BookRepository underTest;

  @Autowired
  public BookRepositoryIntegrationTests(BookRepository underTest, AuthorRepository authorRepository) {
    this.underTest = underTest;
    this.authorRepository = authorRepository;
  }

  @Test
  public void testThatBookCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    authorRepository.save(author);
    Book book = TestDataUtil.createTestBook(author);
    underTest.save(book);
    Optional<Book> result = underTest.findById(book.getIsbn());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(book);
  }

  @Test
  public void testThatMultipleBooksCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    authorRepository.save(author);
    Book book1 = TestDataUtil.createTestBook(author);
    underTest.save(book1);
    Book book2 = TestDataUtil.createTestBook2(author);
    underTest.save(book2);
    Iterable<Book> results = underTest.findAll();
    assertThat(results)
        .hasSize(2)
        .containsExactly(book1, book2);
  }

  @Test
  public void testThatBookCanBeUpdatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    authorRepository.save(author);
    Book book1 = TestDataUtil.createTestBook(author);
    underTest.save(book1);
    Book book2 = TestDataUtil.createTestBook2(author);
    book2.setIsbn(book1.getIsbn());
    underTest.save(book2);
    Optional<Book> result = underTest.findById(book1.getIsbn());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(book2);
  }

  @Test
  public void testThatBookCanBeDeleted() {
    Author author = TestDataUtil.createTestAuthor();
    authorRepository.save(author);
    Book book = TestDataUtil.createTestBook(author);
    underTest.save(book);
    underTest.deleteById(book.getIsbn());
    Optional<Book> result = underTest.findById(book.getIsbn());
    assertThat(result).isEmpty();
  }

}
