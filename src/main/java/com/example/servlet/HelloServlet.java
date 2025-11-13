package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // resp.getWriter().println("<title>Document</title>");
        // resp.getWriter().println("<h1>Maruf Hossain 2</h1>");
        // resp.getWriter().println("<script>alert('Hey')</script>");
        resp.getWriter().println("""
            <html>
                <head>
                    <title>Document Title </title>
                </head>
                <body>
                    <h1>Md. Maruf Hossain</h1>
                </body>
                </head>
            </html>
        """);
    }
}
