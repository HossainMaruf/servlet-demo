package com.example.servlet;

import java.io.IOException;
import com.google.gson.Gson;
import com.example.model.User;
import com.example.orm.Model;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/users")
public class UserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        Model<User> model = new User();
        String json = new Gson().toJson(model.all());
        res.getWriter().write(json);
    }    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write("Reach");
    }
}
