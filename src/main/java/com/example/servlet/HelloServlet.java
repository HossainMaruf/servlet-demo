package com.example.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json"); 
        res.setCharacterEncoding("UTF-8");
        String jsonRes = """
                {
                    "name": "Maruf Hossain",
                    "age": 26,
                    "email": "maruficepustian@gmail.com"
                } 
                """;
        PrintWriter out = res.getWriter();
        out.print(jsonRes);
        out.flush();
    }
}
