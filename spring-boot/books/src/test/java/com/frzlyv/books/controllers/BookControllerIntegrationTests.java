package com.frzlyv.books.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.frzlyv.books.TestDataUtil;
import com.frzlyv.books.domain.dto.BookDto;
import com.frzlyv.books.domain.entities.BookEntity;
import com.frzlyv.books.services.BookService;

import tools.jackson.databind.ObjectMapper;

/**
 * BookControllerIntegrationTests
 */
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;
  private BookService bookService;

  public BookControllerIntegrationTests(MockMvc mockMvc, BookService bookService) {
    this.mockMvc = mockMvc;
    this.objectMapper = new ObjectMapper();
    this.bookService = bookService;
  }

  @Test
  public void testThatCreateBookReturnsHttp201Created() throws Exception {
    BookDto testBook = TestDataUtil.createTestBookDto(null);
    String bookJson = objectMapper.writeValueAsString(testBook);

    mockMvc.perform(
        MockMvcRequestBuilders.put("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookJson))
        .andExpect(
            MockMvcResultMatchers.status().isCreated());
  }

  @Test
  public void testThatCreateBookReturnsSavedBook() throws Exception {
    BookDto testBook = TestDataUtil.createTestBookDto(null);
    String bookJson = objectMapper.writeValueAsString(testBook);

    mockMvc.perform(
        MockMvcRequestBuilders.put("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookJson))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.isbn").value(testBook.getIsbn()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(testBook.getTitle()));
  }

  @Test
  public void testThatListBooksReturnsHttp200Ok() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/books")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testThatListBooksReturnsListOfBooks() throws Exception {
    BookEntity bookEntity = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(bookEntity);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/books")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[0].isbn").value(bookEntity.getIsbn()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[0].title").value(bookEntity.getTitle()));
  }

  @Test
  public void testThatFindOneBookReturnsHttp200Ok() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(testBook);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testThatFindOneBookReturnsHttp404NotFound() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/books/99")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  public void testThatFindOneBookReturnsBook() throws Exception {
    BookEntity bookEntity = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(bookEntity);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/books/" + bookEntity.getIsbn())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.isbn").value(bookEntity.getIsbn()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(bookEntity.getTitle()));
  }

  @Test
  public void testThatFullUpdateBookReturnsHttp200Ok() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(testBook);

    BookDto changedBook = TestDataUtil.createTestBookDto2(null);
    changedBook.setIsbn(testBook.getIsbn());
    String changedBookJson = objectMapper.writeValueAsString(changedBook);

    mockMvc.perform(
        MockMvcRequestBuilders.put("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(changedBookJson))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testThatFullUpdateBookReturnsSavedBook() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(testBook);

    BookDto changedBook = TestDataUtil.createTestBookDto2(null);
    changedBook.setIsbn(testBook.getIsbn());
    String changedBookJson = objectMapper.writeValueAsString(changedBook);

    mockMvc.perform(
        MockMvcRequestBuilders.put("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(changedBookJson))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.isbn").value(changedBook.getIsbn()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(changedBook.getTitle()));
  }

  @Test
  public void testThatPartialUpdateBookReturnsHttp200Ok() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(testBook);

    BookDto changedBook = TestDataUtil.createTestPartialBookDto(null);
    changedBook.setIsbn(testBook.getIsbn());
    String changedBookJson = objectMapper.writeValueAsString(changedBook);

    mockMvc.perform(
        MockMvcRequestBuilders.put("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(changedBookJson))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testThatPartialUpdateExistingBookReturnsUpdatedBook() throws Exception {
    BookEntity testBookEntity = TestDataUtil.createTestBookEntity(null);
    BookEntity savedBook = bookService.createBook(testBookEntity);

    BookDto testBookChanged = TestDataUtil.createTestPartialBookDto(null);
    String bookDtoJson = objectMapper.writeValueAsString(testBookChanged);

    mockMvc.perform(
        MockMvcRequestBuilders.patch("/books/" + savedBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookDtoJson))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.isbn").value(savedBook.getIsbn()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.title").value(testBookChanged.getTitle()));
  }

  @Test
  public void testThatDeleteBookReturnsHttp404NotFound() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.delete("/books/99")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  @Test
  public void testThatDeleteBookReturnsHttp204NoContent() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    bookService.createBook(testBook);

    mockMvc.perform(
        MockMvcRequestBuilders.delete("/books/" + testBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNoContent());
  }

  @Test
  public void testThatDeleteBookDeletesBook() throws Exception {
    BookEntity testBook = TestDataUtil.createTestBookEntity(null);
    BookEntity savedBook = bookService.createBook(testBook);

    mockMvc.perform(
        MockMvcRequestBuilders.delete("/books/" + savedBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNoContent());

    mockMvc.perform(
        MockMvcRequestBuilders.get("/books/" + savedBook.getIsbn())
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isNotFound());
  }

}
