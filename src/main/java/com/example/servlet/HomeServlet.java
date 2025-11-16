package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({ "/", "/contact", "/help", "/dashboard" })
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter writer = res.getWriter();
        switch(req.getServletPath()) {
            case "/":
               writer.write("Home Page");
               break;
            case "/contact":
                writer.write("Contact Page");
                break;
            case "/help":
                writer.write("Help Page");
                break;
            case "/dashboard":
                writer.write("Dashboard");
                break;
            default:
                writer.write("Page Not Found");
                break;
        }
        writer.flush();
        writer.close();
    }
}