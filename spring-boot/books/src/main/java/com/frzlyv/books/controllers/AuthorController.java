package com.frzlyv.books.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frzlyv.books.domain.dto.AuthorDto;
import com.frzlyv.books.domain.entities.AuthorEntity;
import com.frzlyv.books.mappers.Mapper;
import com.frzlyv.books.services.AuthorService;

/**
 * AuthorController
 */
@RestController
public class AuthorController {

  private AuthorService authorService;
  private Mapper<AuthorEntity, AuthorDto> authorMapper;

  public AuthorController(AuthorService authorService, Mapper<AuthorEntity, AuthorDto> authorMapper) {
    this.authorService = authorService;
    this.authorMapper = authorMapper;
  }

  @PostMapping("/authors")
  public AuthorDto createAuthor(@RequestBody AuthorDto bodyAuthor) {
    AuthorEntity authorEntity = authorMapper.toEntity(bodyAuthor);
    AuthorEntity resultAuthorEntity = authorService.create(authorEntity);
    return authorMapper.toDto(resultAuthorEntity);
  }

}
