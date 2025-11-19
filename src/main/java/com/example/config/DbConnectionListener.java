package com.example.config;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import com.example.database.Database;

@WebListener
public class DbConnectionListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Database db = Database.getInstance();
            // checking db is connected or not
            if (db.getConnectionStatus() == 1) {
                System.out.println("Database connected successfully at startup!");
                // Uncomment For Auto Migration Everytime App Startup
                // Migration.run();
            } else {
                System.out.println("Database connection failed at startup!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            Connection conn = Database.getInstance().getConnection();
            if(conn != null && !conn.isClosed()) { conn.close(); }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
