package com.example.utility;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import com.example.annotations.PrimaryKey;
import com.example.annotations.Unique;

public class SqlGenerator {
     private static List<String> sql = null;
     private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS";
     private static final String DROP_TABLE = "DROP TABLE IF EXISTS";
     private static final String SELECT_ALL = "SELECT * FROM";
     private static final String WHERE = "WHERE";
     private static final String OPEN_PAREN = "(";
     private static final String CLOSE_PAREN = ")";
     private static final String SEMICOLON = ";";
     private static final String COMMA = ",";
     private static final String NEWLINE = "\n";
     private static final String SPACE = " ";
     private static final String PRIMARY_KEY = "PRIMARY KEY";
     private static final String FOREIGN_KEY = "FOREIGN KEY";
     private static final String NOT_NULL = "NOT NULL";
     private static final String AUTO_INCREMENT = "AUTO_INCREMENT";
     private static final String UNIQUE = "UNIQUE";
     private static final String LIMIT = "LIMIT";

     public static String getTableName(Class<?> modelClass) {
        return modelClass.getSimpleName().toLowerCase() + "s"; // User -> users
     }

     public static String generateCreateTable(Class<?> modelClass) {
          List<String> sql = new ArrayList<>();
          // store the prefix
          sql.add(CREATE_TABLE);
          sql.add(getTableName(modelClass));
          sql.add(OPEN_PAREN);

          // Store all columns
          List<String> columns = new ArrayList<String>();
          // Fields in Model Class
          Field[] fields = modelClass.getDeclaredFields();
          for(Field field : fields) {
               String fieldName = field.getName();
               Class<?> fieldType = field.getType();
               String sqlType = SqlTypeMapper.map(fieldType);
               // Store Single Column Info
               List<String> column = new ArrayList<String>();
               column.add(fieldName);
               column.add(sqlType);

               // Primary Key
               PrimaryKey pk = field.getAnnotation(PrimaryKey.class);
               if(pk != null) {
                    if(pk.autoIncrement()) { column.add(AUTO_INCREMENT); }
                    column.add(PRIMARY_KEY);
               }

               // Unique
               Unique unique = field.getAnnotation(Unique.class);
               if(unique != null) {
                    column.add(UNIQUE);
               }
               columns.add(String.join(SPACE, column));
          }
          sql.add(String.join(COMMA+NEWLINE, columns));
          sql.add(CLOSE_PAREN+SEMICOLON);
          return String.join(NEWLINE, sql);
     }

     public static String generateDropTable(Class<?> modelClass) {
         List<String> sql = new ArrayList<String>(); 
         sql.add(DROP_TABLE);
         sql.add(getTableName(modelClass) + SEMICOLON);
         return String.join(SPACE, sql);
     }


     public static String generateSelectAll(Class<?> modeClass) {
          List<String> sql = new ArrayList<String>();
          sql.add(SELECT_ALL);
          sql.add(getTableName(modeClass)+SEMICOLON);
          return String.join(SPACE, sql);
     }

     // public static String generateWhereClause(Class<?> modeClass) {
     //      List<String> sql = new ArrayList<String>();
     //      /**
     //       * * from users where id = 10
     //       */

     // }

     // User user = new User();

     // public static SqlGenerator all() {
     //      return new SqlGenerator();
     // }

     // public static SqlGenerator where(String field, String operator, String value) {
     //      // return String.join(SPACE, List.of(field, operator, value));
     //      return this;
     // }
}