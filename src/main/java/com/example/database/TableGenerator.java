package com.example.database;

import java.util.List;
import java.lang.reflect.Field;
import java.util.ArrayList;
import com.example.utility.Naming;
import com.example.utility.SqlTypeMapper;

public class TableGenerator {
     public static String generateCreateTable(Class<?> modelClass) {
          // get the table name in lowercase and plural
          String tableName = Naming.modelToTableName(modelClass);
          // building the sql query of create table command
          StringBuilder sql = new StringBuilder("CREATE TABLE " + tableName + " (\n");
          // get all the fields from the model class
          Field[] fields = modelClass.getDeclaredFields();
          // store the column definition of the table from model class
          List<String> columnDefs = new ArrayList<>();
          
          for(Field field : fields) {
               Class<?> type = field.getType();
               String sqlType = SqlTypeMapper.map(type);
               columnDefs.add(" " + field.getName() + " " + sqlType);
          }
          sql.append(String.join(",\n", columnDefs));
          sql.append("\n);");
          return sql.toString();
     }
}