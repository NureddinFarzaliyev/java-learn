package com.frzlyv.books.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.frzlyv.books.domain.dto.AuthorDto;
import com.frzlyv.books.domain.entities.AuthorEntity;
import com.frzlyv.books.mappers.Mapper;

/**
 * AuthorMapper
 */
@Component
public class AuthorMapper implements Mapper<AuthorEntity, AuthorDto> {

  private ModelMapper modelMapper;

  public AuthorMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public AuthorDto toDto(AuthorEntity e) {
    return modelMapper.map(e, AuthorDto.class);
  }

  @Override
  public AuthorEntity toEntity(AuthorDto d) {
    return modelMapper.map(d, AuthorEntity.class);
  }

}
