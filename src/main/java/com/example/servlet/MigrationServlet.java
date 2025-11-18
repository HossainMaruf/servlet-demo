package com.example.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.example.migrations.AutoMigration;

@WebServlet("/migrate")
public class MigrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AutoMigration.run("com.example.model");
            resp.getWriter().write("Migration completed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Migration failed: " + e.getMessage());
        }
    }
}
