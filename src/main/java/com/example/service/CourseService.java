package com.example.service;

import java.util.List;
import com.example.model.Course;
import org.springframework.stereotype.Service;

import com.example.repository.CourseRepository;

@Service
public class CourseService {
   private final CourseRepository repository; 
   public CourseService(CourseRepository repository) {
       this.repository = repository;
   }

   // get all courses
   public List<Course> getAllCourses() {
       return repository.findAll();
   }
}
