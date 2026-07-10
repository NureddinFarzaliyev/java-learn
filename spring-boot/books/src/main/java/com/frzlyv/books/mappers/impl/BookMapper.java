
package com.frzlyv.books.mappers.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.frzlyv.books.domain.dto.BookDto;
import com.frzlyv.books.domain.entities.BookEntity;
import com.frzlyv.books.mappers.Mapper;

/**
 * BookMapper
 */
@Component
public class BookMapper implements Mapper<BookEntity, BookDto> {

  private ModelMapper modelMapper;

  public BookMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public BookDto toDto(BookEntity e) {
    return modelMapper.map(e, BookDto.class);
  }

  @Override
  public BookEntity toEntity(BookDto d) {
    return modelMapper.map(d, BookEntity.class);
  }

}
