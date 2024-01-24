package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class DomainWelcomeBlogPosts {

  @Produces
  @ApplicationScoped
  public BlogPost firstBlogPost() {
    return BlogPost
      .builder()
      .title("Mein erster BlogPost mit Producer Method")
      .content("Ich weiss dass b<script>alert('Ätschbätsch');</script>c.")
      .build();
  }

  @Produces
  @ApplicationScoped
  public BlogPost secondBlogPost() {
    return BlogPost
      .builder()
      .title("Mein zweiter BlogPost")
      .content("Tralala")
      .build();
  }

}
