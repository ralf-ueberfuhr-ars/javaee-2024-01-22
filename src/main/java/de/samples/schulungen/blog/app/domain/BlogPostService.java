package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@ApplicationScoped
public class BlogPostService {

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
    post.setId(UUID.randomUUID());
    post.setTimestamp(LocalDateTime.now());
    blogPosts.put(post.getId(), post);
  }

  public void remove(UUID id) {
    blogPosts.remove(id);
  }

}
