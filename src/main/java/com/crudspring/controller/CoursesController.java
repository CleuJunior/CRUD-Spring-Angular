package com.crudspring.controller;

import com.crudspring.model.Course;
import com.crudspring.repository.CourseRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CourseRepository courseRepository;

    public CoursesController(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;

        this.courseRepository.save(new Course(null, "Angular", "Front-end"));
        this.courseRepository.save(new Course(null, "Spring Boot", "Back-end"));
        this.courseRepository.save(new Course(null, "MySQL", "DataBase"));
        this.courseRepository.save(new Course(null, "Docker", "DevOps"));
        this.courseRepository.save(new Course(null, "PHP + React", "FullStack"));

    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Course> listOfCourse() {
        return this.courseRepository.findAll();
    }
}
