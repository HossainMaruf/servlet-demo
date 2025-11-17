package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
        String response = routes.getOrDefault(req.getServletPath(), "Page Not Found"); 
        writer.write(response);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doDelete(req, resp);
    }

}