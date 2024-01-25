package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Validated
@ApplicationScoped
//@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostService {

  // TODO interceptor
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


  @PublishEvent(BlogPostCreatedEvent.class)
  public void add(@Valid BlogPost post) {
    post.setId(UUID.randomUUID());
    post.setTimestamp(LocalDateTime.now());
    blogPosts.put(post.getId(), post);
    BlogPostCreatedEvent event = new BlogPostCreatedEvent(post);
    eventPublisher.fire(event);
  }

  public void remove(UUID id) {
    blogPosts.remove(id);
  }

}
