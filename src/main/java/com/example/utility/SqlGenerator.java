package com.example.utility;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;

import com.example.annotations.PrimaryKey;
import com.example.annotations.Unique;

public class SqlGenerator {
     public static String generateCreateTable(Class<?> modelClass) {
          // get the table name in lowercase and plural
          String tableName = Naming.modelToTableName(modelClass);
          // building the sql query of create table command
          StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + tableName + " (\n");
          // get all the fields from the model class
          Field[] fields = modelClass.getDeclaredFields();
          // store the column definition of the table from model class
          List<String> columnDefs = new ArrayList<>();
          
          for(Field field : fields) {
               String columnName = field.getName();
               Class<?> type = field.getType();
               String sqlType = SqlTypeMapper.map(type);

               StringBuilder column = new StringBuilder(" " + columnName + " " + sqlType);

               // Primary Key
               PrimaryKey pk = field.getAnnotation(PrimaryKey.class);
               if(pk != null) {
                    if(pk.autoIncrement()) { column.append(" AUTO_INCREMENT"); }
                    column.append(" PRIMARY KEY");
               }

               // Unique
               Unique unique = field.getAnnotation(Unique.class);
               if(unique != null) {
                    column.append(" UNIQUE");
               }
               columnDefs.add(column.toString());
          }
          sql.append(String.join(",\n", columnDefs));
          sql.append("\n);");
          return sql.toString();
     }
}