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

  public BookControllerIntegrationTests(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
    this.objectMapper = new ObjectMapper();
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

}
