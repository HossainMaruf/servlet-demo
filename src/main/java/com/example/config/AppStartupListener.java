package com.example.config;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import com.example.database.Database;

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
                // AutoMigration.run("com.example.models");
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
