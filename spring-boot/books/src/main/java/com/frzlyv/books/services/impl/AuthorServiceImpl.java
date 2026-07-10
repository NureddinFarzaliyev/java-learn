package com.frzlyv.books.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.frzlyv.books.domain.entities.AuthorEntity;
import com.frzlyv.books.repositories.AuthorRepository;
import com.frzlyv.books.services.AuthorService;

/**
 * AuthorServiceImpl
 */
@Service
public class AuthorServiceImpl implements AuthorService {

  private AuthorRepository authorRepository;

  public AuthorServiceImpl(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @Override
  public AuthorEntity create(AuthorEntity authorEntity) {
    return authorRepository.save(authorEntity);
  }

  @Override
  public List<AuthorEntity> listAll() {
    return StreamSupport
        .stream(authorRepository.findAll()
            .spliterator(),
            false)
        .collect(Collectors.toList());
  }

}
