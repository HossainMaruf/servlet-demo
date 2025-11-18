// package com.example.utility;

import java.lang.reflect.Field;

public class Naming {
   public String name;
   public static String modelToTableName(Class<?> cls) {
        String name = cls.getSimpleName().toLowerCase();
        return name + "s"; // User -> users
   } 
}

class Main  {
    public static void main(String[] args) {
        Class<?> cls = Naming.class;
        System.out.println(cls.getModifiers());
        Field[] fields = cls.getDeclaredFields();
        for(Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getName().);
        }
    }
}