package de.samples.schulungen.blog.app.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BlogPostCreatedEvent {

  private final BlogPost blogPost;

}
