package com.example.utility;

public class SqlTypeMapper {
   public static String map(Class<?> type) {
        if(type == int.class || type == Integer.class) return "INT";
        if(type == long.class || type == Long.class) return "BIGINT";
        if(type == String.class) return "VARCHAR(255)";
        return "TEXT"; // fallback
   } 
}
