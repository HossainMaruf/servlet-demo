package com.example.config;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.Statement;

import com.example.database.Database;
import com.example.migrations.AutoMigration;
import com.example.model.User;
import com.example.utility.SqlGenerator;

@WebListener
public class AppStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=== Application Starting ===");
        try {
            Database db = Database.getInstance();
            // checking db is connected or not
            if (db.getConnectionStatus() == 1) {
                System.out.println("Database connected successfully at startup!");
                // TODO AutoMigration Here
                String sql = SqlGenerator.generateCreateTable(User.class);
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                int result = stmt.executeUpdate(sql);
                System.out.println(result);
            } else {
                System.out.println("Database connection failed at startup!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=== Application Stopped ===");
    }
}
