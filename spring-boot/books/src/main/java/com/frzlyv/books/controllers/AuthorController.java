package com.frzlyv.books.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/authors/{id}")
  public ResponseEntity<AuthorDto> findOneAuthor(@PathVariable Long id) {
    return authorService.findOne(id)
        .map(authorMapper::toDto)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PutMapping("/authors/{id}")
  public ResponseEntity<AuthorDto> fullUpdateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
    Boolean exists = authorService.isExists(id);
    if (!exists) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    authorDto.setId(id);
    AuthorEntity authorEntity = authorMapper.toEntity(authorDto);
    AuthorEntity updatedEntity = authorService.create(authorEntity);
    AuthorDto responseDto = authorMapper.toDto(updatedEntity);
    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @PatchMapping(path = "/authors/{id}")
  public ResponseEntity<AuthorDto> partialUpdate(
      @PathVariable("id") Long id,
      @RequestBody AuthorDto authorDto) {
    if (!authorService.isExists(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    AuthorEntity authorEntity = authorMapper.toEntity(authorDto);
    AuthorEntity updatedAuthor = authorService.partialUpdate(id, authorEntity);
    return new ResponseEntity<>(
        authorMapper.toDto(updatedAuthor),
        HttpStatus.OK);
  }

  @DeleteMapping("/authors/{id}")
  public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
    if (!authorService.isExists(id)) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
      authorService.delete(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }
}
