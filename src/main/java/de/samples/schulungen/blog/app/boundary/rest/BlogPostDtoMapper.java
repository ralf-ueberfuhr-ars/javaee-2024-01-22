package de.samples.schulungen.blog.app.boundary.rest;

import de.samples.schulungen.blog.app.domain.BlogPost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface BlogPostDtoMapper {

  @Mapping(target = "timestamp", ignore = true)
  BlogPost map(BlogPostDto source);
  BlogPostDto map(BlogPost source);

}
