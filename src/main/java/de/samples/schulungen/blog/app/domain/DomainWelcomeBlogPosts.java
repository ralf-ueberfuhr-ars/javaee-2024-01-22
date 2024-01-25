package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DomainWelcomeBlogPosts {

  @Produces
  @ApplicationScoped
  public BlogPostProvider firstBlogPost() {
    return () -> BlogPost
      .builder()
      .title("Mein erster BlogPost mit Producer Method")
      .content("Ich weiss dass b<script>alert('Ätschbätsch');</script>c.")
      .build();
  }

  @Produces
  @ApplicationScoped
  public BlogPostProvider secondBlogPost() {
    return () -> BlogPost
      .builder()
      .title("Mein zweiter BlogPost")
      .content("Tralalalalalal")
      .build();
  }

}
