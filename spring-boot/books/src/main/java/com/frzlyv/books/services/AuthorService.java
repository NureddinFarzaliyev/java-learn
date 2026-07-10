package com.frzlyv.books.services;

import java.util.List;
import java.util.Optional;

import com.frzlyv.books.domain.entities.AuthorEntity;

/**
 * AuthorService
 */
public interface AuthorService {

  AuthorEntity create(AuthorEntity authorEntity);

  List<AuthorEntity> listAll();

  Optional<AuthorEntity> findOne(Long id);

  Boolean isExists(Long id);

  AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity);

  void delete(Long id);
}
