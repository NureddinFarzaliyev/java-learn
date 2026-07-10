package com.frzlyv.books.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto bodyAuthor) {
    AuthorEntity authorEntity = authorMapper.toEntity(bodyAuthor);
    AuthorEntity resultAuthorEntity = authorService.create(authorEntity);
    AuthorDto responseAuthorDto = authorMapper.toDto(resultAuthorEntity);
    return new ResponseEntity<>(responseAuthorDto, HttpStatus.CREATED);
  }

  @GetMapping("/authors")
  public List<AuthorDto> listAuthors() {
    List<AuthorEntity> authorEntities = authorService.listAll();
    return authorEntities.stream()
        .map(authorMapper::toDto)
        .collect(Collectors.toList());
  }

}
