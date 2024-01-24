package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

@ApplicationScoped
public class BlogPostInitializer {

  // TODO Constructor Injection
  @Inject
  BlogPostService service;

  public void init(
    @Observes
    @Initialized(ApplicationScoped.class)
    Object pointless
  ) {
    service.add(
      BlogPost
        .builder()
        .title("Mein erster BlogPost mit Initializer")
        .content("Ich weiss dass b<script>alert('Ätschbätsch');</script>c.")
        .build()
    );
    service.add(
      BlogPost
        .builder()
        .title("Mein zweiter BlogPost")
        .content("Tralala")
        .build()
    );
  }

}
