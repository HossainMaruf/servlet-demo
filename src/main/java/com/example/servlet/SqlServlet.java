package com.example.servlet;

import java.io.IOException;

import com.example.model.User;
import com.example.utility.SqlGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sql")
public class SqlServlet extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String sql = SqlGenerator.generateCreateTable(User.class);
        res.getWriter().write(sql);
   } 
}
