package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class BlogPostService {

  private final Map<UUID, BlogPost> blogPosts = new HashMap<>();

  {
    this.add(
      BlogPost
        .builder()
        .title("Mein erster BlogPost mit CDI")
        .content("Ich weiss dass b<script>alert('Ätschbätsch');</script>c.")
        .build()
    );
    this.add(
      BlogPost
        .builder()
        .title("Mein zweiter BlogPost")
        .content("Tralala")
        .build()
    );
  }

  public Collection<BlogPost> findAll() {
    return blogPosts.values();
  }

  public BlogPost findById(UUID id) {
    return blogPosts.get(id);
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
