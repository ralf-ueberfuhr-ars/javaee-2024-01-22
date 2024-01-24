package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@ApplicationScoped
public class BlogPostService {

  private final Map<UUID, BlogPost> blogPosts = new HashMap<>();

  {
    this.add(
      BlogPost
        .builder()
        .title("Mein erster BlogPost mit CDI")
        .content("Ich weiss dass b<script>alert('Ätschbätsch');</script>c.")
        .timestamp(LocalDateTime.now())
        .build()
    );
    this.add(
      BlogPost
        .builder()
        .title("Mein zweiter BlogPost")
        .content("Tralala")
        .timestamp(LocalDateTime.now())
        .build()
    );
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
    post.setId(UUID.randomUUID());
    blogPosts.put(post.getId(), post);
  }

  public void remove(UUID id) {
    blogPosts.remove(id);
  }

}
