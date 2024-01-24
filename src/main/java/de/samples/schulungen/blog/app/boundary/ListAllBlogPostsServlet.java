package de.samples.schulungen.blog.app.boundary;

import de.samples.schulungen.blog.app.domain.BlogPost;
import de.samples.schulungen.blog.app.domain.BlogPostService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@WebServlet("/list-blogposts")
public class ListAllBlogPostsServlet extends HttpServlet {

  @Inject
  private BlogPostService service;

  @Override
  protected void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {

    // BlogPosts ermitteln - Dummy!
    Collection<BlogPost> blogposts = service
      .findAll()
      .collect(Collectors.toList());

    //BlogPost result = service
      //.findById(UUID.randomUUID())
      //.orElseThrow(IllegalStateException::new);
      //.orElseGet(() -> BlogPost.builder().build());

    req.setAttribute("blogposts", blogposts);

    getServletContext()
      .getRequestDispatcher("/WEB-INF/jsps/output-blogposts.jsp")
      .forward(req, resp);
  }
}
