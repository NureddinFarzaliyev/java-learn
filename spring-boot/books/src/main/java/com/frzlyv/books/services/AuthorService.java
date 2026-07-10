package com.frzlyv.books.services;

import java.util.List;

import com.frzlyv.books.domain.entities.AuthorEntity;

/**
 * AuthorService
 */
public interface AuthorService {

  AuthorEntity create(AuthorEntity authorEntity);

  List<AuthorEntity> listAll();

}
