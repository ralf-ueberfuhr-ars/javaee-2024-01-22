package de.samples.schulungen.blog.app.domain;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class BlogPostEventLogger {

  public void logBlogPostCreated(@Observes BlogPostCreatedEvent event) {
    System.out.println("BlogPost created: " + event.getBlogPost());
  }

}
