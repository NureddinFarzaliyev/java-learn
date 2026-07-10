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
import com.frzlyv.books.domain.dto.AuthorDto;
import com.frzlyv.books.domain.entities.AuthorEntity;
import com.frzlyv.books.services.AuthorService;

import tools.jackson.databind.ObjectMapper;

/**
 * AuthorControllerIntegrationTests
 */
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTests {

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;
  private AuthorService authorService;

  public AuthorControllerIntegrationTests(MockMvc mockMvc, AuthorService authorService) {
    this.mockMvc = mockMvc;
    this.objectMapper = new ObjectMapper();
    this.authorService = authorService;
  }

  @Test
  public void testThatCreateAuthorReturnsHttp201Created() throws Exception {
    AuthorDto testAuthor = TestDataUtil.createTestAuthorDto();
    String authorJson = objectMapper.writeValueAsString(testAuthor);

    mockMvc.perform(
        MockMvcRequestBuilders.post("/authors")
            .contentType(MediaType.APPLICATION_JSON)
            .content(authorJson))
        .andExpect(
            MockMvcResultMatchers.status().isCreated());
  }

  @Test
  public void testThatCreateAuthorReturnsSavedAuthor() throws Exception {
    AuthorDto testAuthor = TestDataUtil.createTestAuthorDto();
    String authorJson = objectMapper.writeValueAsString(testAuthor);

    mockMvc.perform(
        MockMvcRequestBuilders.post("/authors")
            .contentType(MediaType.APPLICATION_JSON)
            .content(authorJson))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.id").isNumber())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.name").value(testAuthor.getName()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.age").value(testAuthor.getAge()));

  }

  @Test
  public void testThatListAuthorsReturnsHttp200Ok() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/authors")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void testThatListAuthorsReturnsListOfAuthors() throws Exception {
    AuthorEntity testAuthor = TestDataUtil.createTestAuthorEntity();
    authorService.create(testAuthor);

    mockMvc.perform(
        MockMvcRequestBuilders.get("/authors")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[0].name").value(testAuthor.getName()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$[0].age").value(testAuthor.getAge()));
  }

}
