package com.example.utility;

public class Naming {
   public static String modelToTableName(Class<?> cls) {
        return cls.getSimpleName().toLowerCase() + "s"; // User -> users
   } 
}