package com.frzlyv.books.services.impl;

import java.util.List;
import java.util.Optional;

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
    return authorRepository.findAll();
  }

  @Override
  public Optional<AuthorEntity> findOne(Long id) {
    return authorRepository.findById(id);
  }

  @Override
  public Boolean isExists(Long id) {
    return authorRepository.existsById(id);
  }
}
