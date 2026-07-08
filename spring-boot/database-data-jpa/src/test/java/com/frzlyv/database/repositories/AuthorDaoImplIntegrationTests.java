// package com.frzlyv.database.dao.impl;
//
// import java.util.List;
// import java.util.Optional;
//
// import static org.assertj.core.api.Assertions.assertThat;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.annotation.DirtiesContext;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
//
// import com.frzlyv.database.TestDataUtil;
// import com.frzlyv.database.domain.Author;
//
// /**
// * AuthorDaoImplIntegrationTests
// */
// @SpringBootTest
// @ExtendWith(SpringExtension.class)
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// public class AuthorDaoImplIntegrationTests {
//
// private AuthorDaoImpl underTest;
//
// @Autowired
// public AuthorDaoImplIntegrationTests(AuthorDaoImpl underTest) {
// this.underTest = underTest;
// }
//
// @Test
// public void testThatAuthorCanBeCreatedAndRecalled() {
// Author author = TestDataUtil.createTestAuthor();
// underTest.create(author);
// Optional<Author> result = underTest.findOne(author.getId());
// assertThat(result).isPresent();
// assertThat(result.get()).isEqualTo(author);
// }
//
// @Test
// public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
// Author author1 = TestDataUtil.createTestAuthor();
// underTest.create(author1);
// Author author2 = TestDataUtil.createTestAuthor2();
// underTest.create(author2);
// List<Author> results = underTest.find();
// assertThat(results)
// .hasSize(2)
// .containsExactly(author1, author2);
// }
//
// @Test
// public void testThatAuthorCanBeUpdatedAndRecalled() {
// Author author1 = TestDataUtil.createTestAuthor();
// underTest.create(author1);
// Author author2 = TestDataUtil.createTestAuthor2();
// author2.setId(author1.getId());
// underTest.update(author2);
// Optional<Author> result = underTest.findOne(author1.getId());
// assertThat(result).isPresent();
// assertThat(result.get()).isEqualTo(author2);
// }
//
// @Test
// public void testThatAuthorCanBeDeleted() {
// Author author = TestDataUtil.createTestAuthor();
// underTest.create(author);
// underTest.delete(author.getId());
// Optional<Author> result = underTest.findOne(author.getId());
// assertThat(result).isEmpty();
// }
//
// }
