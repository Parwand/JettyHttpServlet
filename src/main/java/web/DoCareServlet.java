package web;

import org.eclipse.jetty.util.ajax.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DoCareServlet extends HttpServlet {

    List<String> response = List.of(
            "<!DOCTYPE html>",
            "<html>",
            "<head>",
            "<title>Home Page</title>",
            "</head>",
            "<body>",
            "<h1>I do Care</h1>",
            "</body>",
            "</html>"
    );

    String jsonResponse = JSON.toString(response);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("the URL in DoCareServlet: "+requestURL);

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        response.forEach(writer::println);
    }
}
