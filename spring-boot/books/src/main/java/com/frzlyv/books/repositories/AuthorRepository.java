package com.frzlyv.books.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frzlyv.books.domain.entities.AuthorEntity;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

}
