package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Class;

public class Database {
   private static Database instance = null;
   private Connection conn = null;

   private Database(String url, String username, String password) {
      try {
         // Load MySQL JDBC Driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public static synchronized Database getInstance() {
      if (instance == null) {
         // Change to your DB info
         String url = "jdbc:mysql://localhost:3306/servlet";
         // Your DB username
         String username = "root";
         // Your DB password
         String password = "";
         instance = new Database(url, username, password);
      }
      return instance;
   }

   public int getConnectionStatus() throws SQLException {
      return (conn != null && !conn.isClosed()) ? 1 : 0;
   }

   public Connection getConnection() {
      return conn;
   }
}
