package com.frzlyv.books.mappers;

/**
 * Mapper
 */
public interface Mapper<Entity, DTO> {

  Entity toEntity(DTO d);

  DTO toDto(Entity e);

}
