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
// import com.frzlyv.database.dao.AuthorDao;
// import com.frzlyv.database.domain.Author;
// import com.frzlyv.database.domain.Book;
//
// /**
// * BookDaoImplIntegrationTests
// */
// @SpringBootTest
// @ExtendWith(SpringExtension.class)
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
// public class BookDaoImplIntegrationTests {
//
// private AuthorDao authorDao;
// private BookDaoImpl underTest;
//
// @Autowired
// public BookDaoImplIntegrationTests(BookDaoImpl underTest, AuthorDao
// authorDao) {
// this.underTest = underTest;
// this.authorDao = authorDao;
// }
//
// @Test
// public void testThatBookCanBeCreatedAndRecalled() {
// Author author = TestDataUtil.createTestAuthor();
// authorDao.create(author);
// Book book = TestDataUtil.createTestBook();
// book.setAuthorId(author.getId());
// underTest.create(book);
// Optional<Book> result = underTest.findOne(book.getIsbn());
// assertThat(result).isPresent();
// assertThat(result.get()).isEqualTo(book);
// }
//
// @Test
// public void testThatMultipleBooksCanBeCreatedAndRecalled() {
// Author author = TestDataUtil.createTestAuthor();
// authorDao.create(author);
// Book book1 = TestDataUtil.createTestBook();
// book1.setAuthorId(author.getId());
// underTest.create(book1);
// Book book2 = TestDataUtil.createTestBook2();
// book2.setAuthorId(author.getId());
// underTest.create(book2);
// List<Book> results = underTest.find();
// assertThat(results)
// .hasSize(2)
// .containsExactly(book1, book2);
// }
//
// @Test
// public void testThatBookCanBeUpdatedAndRecalled() {
// Author author = TestDataUtil.createTestAuthor();
// authorDao.create(author);
// Book book1 = TestDataUtil.createTestBook();
// book1.setAuthorId(author.getId());
// underTest.create(book1);
// Book book2 = TestDataUtil.createTestBook2();
// book2.setIsbn(book1.getIsbn());
// book2.setAuthorId(book1.getAuthorId());
// underTest.update(book2);
// Optional<Book> result = underTest.findOne(book1.getIsbn());
// assertThat(result).isPresent();
// assertThat(result.get()).isEqualTo(book2);
// }
//
// @Test
// public void testThatBookCanBeDeleted() {
// Author author = TestDataUtil.createTestAuthor();
// authorDao.create(author);
// Book book = TestDataUtil.createTestBook();
// book.setAuthorId(author.getId());
// underTest.create(book);
// underTest.delete(book.getIsbn());
// Optional<Book> result = underTest.findOne(book.getIsbn());
// assertThat(result).isEmpty();
// }
//
// }
