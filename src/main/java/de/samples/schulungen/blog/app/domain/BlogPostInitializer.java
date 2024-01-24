package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class BlogPostInitializer {

  private final BlogPostService service;
  private final Instance<BlogPost> blogPosts;

  public void init(
    @Observes
    @Initialized(ApplicationScoped.class)
    Object pointless
  ) {
    if (service.count() < 1) {
      blogPosts
        .stream()
        .forEach(service::add);
    }
  }

}
