package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
   @Id 
   private String code;

   @Column(nullable = false)
   private String title;

   public String getCode() {
	return code;
   }

   public void setCode(String code) {
	this.code = code;
   }

   public String getTitle() {
	return title;
   }

   public void setTitle(String title) {
	this.title = title;
   }

}
