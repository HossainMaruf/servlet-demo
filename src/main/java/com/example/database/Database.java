package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Class;
import java.util.Properties;

public class Database {
   private static Database instance = null;
   private Connection conn = null;
   private Properties props;

   private Database() {
      try {
         // 1. Load properties from classpath
         props = new Properties();
         InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
         props.load(in);
         // 2. Resolve ${var} inside values
         resolvePlaceholders(props);
         // Change to your DB info
         String url = props.getProperty("db.url");
         // Your DB username
         String username = props.getProperty("db.username");
         // Your DB password
         String password = props.getProperty("db.password");
         // Load MySQL JDBC Driver
         Class.forName("com.mysql.cj.jdbc.Driver");
         conn = DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException | SQLException | IOException e) {
         e.printStackTrace();
      }
   }

   private void resolvePlaceholders(Properties props) {
       for (String key : props.stringPropertyNames()) {
        String value = props.getProperty(key);

        if (value.contains("${")) {
            for (String innerKey : props.stringPropertyNames()) {
                value = value.replace("${" + innerKey + "}", props.getProperty(innerKey));
            }
            props.setProperty(key, value);
        }
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
