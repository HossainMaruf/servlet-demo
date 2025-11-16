package com.example.mvc.model;

public class User {
   private int id;
   private String name;
   private String email;
   private String phone;
   public User(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
   }
   public User(int id, String name, String email, String phone){
        this(name, email, phone);
        this.id = id;
   }
   public int getId() { return id; }
   public String getName() { return name; }
   public String getEmail() { return email; }
   public String getPhone() { return phone; }
   public void setName(String name) { this.name = name; }
   public void setEmail(String email) { this.email = email; }
   public void setPhone(String phone) { this.phone = phone; }
}