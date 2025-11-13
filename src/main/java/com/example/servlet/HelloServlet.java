package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "Md. Maruf Hossain");
        req.setAttribute("email", "maruficepustian@gmail.com");
        req.setAttribute("designation", "SO-IT");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
