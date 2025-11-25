package com.example.servlet;

import java.io.IOException;

import com.example.model.User;
import com.example.orm.Model;
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
      //   String sql = SqlGenerator.generateSelectAll(User.class);
        Model<User> user = new User();
        String sql = user.query()
        .all("id", "name")
        .whereAND("id","=", "10")
        .whereAND(LEGACY_DO_HEAD, LEGACY_DO_HEAD, LEGACY_DO_HEAD)
        .whereAND;
        res.getWriter().write(sql);
   } 
}
