package de.samples.schulungen.blog.app.boundary;

import de.samples.schulungen.blog.app.domain.BlogPost;
import de.samples.schulungen.blog.app.domain.BlogPostService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;

import java.io.IOException;

@WebServlet("/create-blogpost")
public class CreateBlogPostServlet extends HttpServlet {

  @Inject
  private BlogPostService service;

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Conversion
    BlogPost newBlogPost = BlogPost
      .builder()
      .title(req.getParameter("title"))
      .content(req.getParameter("content"))
      .build();
    // Validation
    if(newBlogPost.getTitle() == null || newBlogPost.getTitle().length()<1) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid title");
      return;
    }
    if(newBlogPost.getContent() == null || newBlogPost.getContent().length()<1) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid content");
      return;
    }
    // Action
    try {
      service.add(newBlogPost);
    } catch(ConstraintViolationException ex) {
      // ex.getConstraintViolations() ..
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "invalid blog post");
      return;
    }
    // Response
    resp.sendRedirect("list-blogposts");
  }
}
