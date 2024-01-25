package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@ApplicationScoped
//@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostService {

  // TODO interceptor
  @Inject
  /*private final*/ Validator validator;
  @Inject
  Event<BlogPostCreatedEvent> eventPublisher;

  private final Map<UUID, BlogPost> blogPosts = new HashMap<>();

  public long count() {
    return blogPosts.size();
  }

  public Stream<BlogPost> findAll() {
    return blogPosts.values().stream();
  }

  public Stream<BlogPost> findAllByTitle(String title) {
    return findAll()
      .filter(blogPost -> blogPost.getTitle().toLowerCase().contains(title.toLowerCase()));
  }

  public Optional<BlogPost> findById(UUID id) {
    return Optional.ofNullable(blogPosts.get(id));
  }

  public void add(BlogPost post) {
    Set<ConstraintViolation<BlogPost>> violations = validator.validate(post);
    if(violations.isEmpty()) {
      post.setId(UUID.randomUUID());
      post.setTimestamp(LocalDateTime.now());
      blogPosts.put(post.getId(), post);
      BlogPostCreatedEvent event = new BlogPostCreatedEvent(post);
      eventPublisher.fire(event);
    } else {
      throw new ConstraintViolationException(violations);
    }
  }

  public void remove(UUID id) {
    blogPosts.remove(id);
  }

}
