package de.samples.schulungen.blog.app.boundary.rest;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BlogPostDto {

  //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private UUID id;
  @NotNull
  @Size(min = 3)
  private String title;
  @Size(min = 10)
  private String content;

}
