package de.samples.schulungen.blog.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@WebServlet("/list-blogposts")
public class ListAllBlogPostsServlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest req,
    HttpServletResponse resp
  ) throws ServletException, IOException {

    // BlogPosts ermitteln - Dummy!
    Collection<BlogPost> blogposts = Arrays.asList(
      //new BlogPost("Mein erster Blog Post!", "Lorem ipsum...", LocalDateTime.now())
      BlogPost
        .builder()
        .title("Mein erster BlogPost")
        .content("Lorem Ipsum...")
        .timestamp(LocalDateTime.now())
        .build(),
      BlogPost
        .builder()
        .title("Mein zweiter BlogPost")
        .content("Tralala")
        .timestamp(LocalDateTime.now())
        .build()
    );

    req.setAttribute("blogposts", blogposts);
    getServletContext()
      .getRequestDispatcher("/WEB-INF/jsps/output-blogposts.jsp")
      .forward(req, resp);
  }
}
