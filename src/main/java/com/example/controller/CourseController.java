package com.example.controller;

import java.util.List;
import com.example.model.Course;
import com.example.service.CourseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) {
        this.service = service;
    }
    // Get all courses
    @GetMapping 
    public List<Course> getAllCourses() { return service.getAllCourses(); }
}
