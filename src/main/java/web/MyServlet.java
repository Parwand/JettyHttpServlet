package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MyServlet extends HttpServlet {
    List<String> response = List.of(
            "<!DOCTYPE html>",
            "<html>",
            "<head>",
            "<title>Home Page</title>",
            "</head>",
            "<body>",
            "<h1>Home Page</h1>",
            "<h2>Tell me The truth: false or true</h2>",
            "<form method=post>",
                "The Truth: <input type=\"text\" name = \"truth\"></input>",
                "<button type=\"submit\">send</button>",
            "</form>",
            "</body>",
            "</html>"
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {PrintWriter writer = resp.getWriter();
        response.forEach(writer::println);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("the URL: "+requestURL);
        String truth = req.getParameter("truth");
        System.out.println("the answer: "+ truth);
        if (truth.equals("true")){
            resp.sendRedirect("/do");
        } else {
            resp.sendRedirect("/dont");
        }
    }
}
