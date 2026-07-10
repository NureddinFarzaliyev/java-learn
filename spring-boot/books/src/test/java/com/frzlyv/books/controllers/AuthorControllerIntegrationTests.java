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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.frzlyv.books.TestDataUtil;
import com.frzlyv.books.domain.entities.AuthorEntity;

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

  public AuthorControllerIntegrationTests(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
    this.objectMapper = new ObjectMapper();
  }

  @Test
  public void testThatCreateAuthorReturnsHttp201Created() throws Exception {

    AuthorEntity testAuthor = TestDataUtil.createTestAuthorEntity();
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

    AuthorEntity testAuthor = TestDataUtil.createTestAuthorEntity();
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

}
