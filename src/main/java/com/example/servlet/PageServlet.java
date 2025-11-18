package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.example.database.TableGenerator;
import com.example.model.User;

@WebServlet({ "/", "/about", "/contact", "/help" })
public class PageServlet extends HttpServlet {
    private Map<String, String> routes;

    @Override
    public void init() throws ServletException {
        super.init();
        routes = Map.of(
            "/", "Home Page", 
            "/about", "About Page", 
            "/contact", "Contact Page",
            "/help", "Help Page"
        );        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter writer = res.getWriter();
        // String response = routes.getOrDefault(req.getServletPath(), "Page Not Found"); 
        // TableGenerator.generateCreateTable(User.class);
        writer.write(TableGenerator.generateCreateTable(User.class));
        writer.flush();
        writer.close();
    }
}