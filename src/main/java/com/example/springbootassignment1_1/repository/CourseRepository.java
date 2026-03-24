package com.example.springbootassignment1_1.repository;

import com.example.springbootassignment1_1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}