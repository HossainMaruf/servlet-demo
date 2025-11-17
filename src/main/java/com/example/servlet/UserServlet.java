package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        String json = "{ \"status\": \"success\", \"message\": \"Hello JSON\" }";
        res.getWriter().write(json);
    }    
}
