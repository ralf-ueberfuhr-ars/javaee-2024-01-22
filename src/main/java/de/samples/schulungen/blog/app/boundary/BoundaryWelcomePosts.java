package de.samples.schulungen.blog.app.boundary;

import de.samples.schulungen.blog.app.domain.BlogPost;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class BoundaryWelcomePosts {

  @Produces
  @ApplicationScoped
  public BlogPost boundaryWelcome() {
    return BlogPost
      .builder()
      .title("We have a boundary!")
      .content("Let's implement servlets")
      .build();
  }

}
