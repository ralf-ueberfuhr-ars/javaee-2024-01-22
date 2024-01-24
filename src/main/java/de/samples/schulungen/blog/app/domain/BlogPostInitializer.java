package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostInitializer {

  private final BlogPostService service;

  public void init(
    @Observes
    @Initialized(ApplicationScoped.class)
    Object pointless
  ) {
    if(service.count()<1) {
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

}
