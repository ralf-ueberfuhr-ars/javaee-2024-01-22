package de.samples.schulungen.blog.app.boundary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req,
            HttpServletResponse resp
    ) throws ServletException, IOException {

        String name = req.getParameter("name");
        String myMessage = "Hello " +
                (name != null ? name : "World");
        /*
        resp.setContentType("text/plain");
        try(PrintWriter out = resp.getWriter()) {
            out.println("Hello " + name);
        }
        */
        req.setAttribute("message", myMessage);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsps/hello.jsp")
                .forward(req, resp);

    }
}
