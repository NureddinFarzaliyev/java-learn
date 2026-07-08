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

/**
 * AuthorDaoImplIntegrationTests
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorRepositoryIntegrationTests {

  private AuthorRepository underTest;

  @Autowired
  public AuthorRepositoryIntegrationTests(AuthorRepository underTest) {
    this.underTest = underTest;
  }

  @Test
  public void testThatAuthorCanBeCreatedAndRecalled() {
    Author author = TestDataUtil.createTestAuthor();
    Author savedAuthor = underTest.save(author);
    Optional<Author> result = underTest.findById(savedAuthor.getId());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(author);
  }

  @Test
  public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
    Author author1 = TestDataUtil.createTestAuthor();
    underTest.save(author1);
    Author author2 = TestDataUtil.createTestAuthor2();
    underTest.save(author2);
    Iterable<Author> results = underTest.findAll();
    assertThat(results)
        .hasSize(2)
        .containsExactly(author1, author2);
  }

  @Test
  public void testThatAuthorCanBeUpdatedAndRecalled() {
    Author author1 = TestDataUtil.createTestAuthor();
    underTest.save(author1);
    Author author2 = TestDataUtil.createTestAuthor2();
    author2.setId(author1.getId());
    underTest.save(author2);
    Optional<Author> result = underTest.findById(author1.getId());
    assertThat(result).isPresent();
    assertThat(result.get()).isEqualTo(author2);
  }

  @Test
  public void testThatAuthorCanBeDeleted() {
    Author author = TestDataUtil.createTestAuthor();
    underTest.save(author);
    underTest.deleteById(author.getId());
    Optional<Author> result = underTest.findById(author.getId());
    assertThat(result).isEmpty();
  }

  @Test
  public void testThatAuthorsWithAgeLessThan() {
    Author author1 = TestDataUtil.createTestAuthor();
    underTest.save(author1);
    Author author2 = TestDataUtil.createTestAuthor2();
    underTest.save(author2);

    Iterable<Author> results = underTest.ageLessThan(25);
    assertThat(results)
        .hasSize(1)
        .containsExactly(author1);

  }

}
