package com.frzlyv.books.services;

import org.springframework.stereotype.Service;

import com.frzlyv.books.domain.entities.AuthorEntity;

/**
 * AuthorService
 */
public interface AuthorService {

  AuthorEntity create(AuthorEntity authorEntity);

}
