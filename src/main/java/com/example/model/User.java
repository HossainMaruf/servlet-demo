package com.example.model;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class User {
   private Map<String, List<String>> fields;
   public User() {
        fields = new HashMap<String, List<String>>();
   }
   public void set(String key, String value) {
       fields.computeIfAbsent(key, k -> new ArrayList<String>()).add(value);
   }
   public List<String> get(String key) {
        return fields.getOrDefault(key, new ArrayList<String>());
   }
   public List<String> getFields() {
        return new ArrayList<String>(fields.keySet());
   }
}

class Main {
    public static void main(String[] args) {
        User user = new User(); 
        user.set("name", "Maruf Hossain");
        user.set("name", "Md. Maruf Hossain");
        user.set("email", "maruficepustian@gmail.com");
        for (String field : user.getFields()) {
            System.out.println(field + " = " + user.get(field));  
        }
    }
}