package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Class;
import java.util.Properties;

import com.example.utility.ApplicationProperties;

public class Database {
   private static Database instance = null;
   private Connection conn = null;
   private Properties props = null;

   private Database() {
      try {
         props = ApplicationProperties.getInstance().getProps();
         // Change to your DB info
         String url = props.getProperty("db.url");
         // Your DB username
         String username = props.getProperty("db.username");
         // Your DB password
         String password = props.getProperty("db.password");
         // Load MySQL JDBC Driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   public static synchronized Database getInstance() {
      if (instance == null) {
         instance = new Database();
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
