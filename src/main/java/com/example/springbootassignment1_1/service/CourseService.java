package com.example.springbootassignment1_1.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springbootassignment1_1.model.Course;
import com.example.springbootassignment1_1.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @PostConstruct
    public void initData() {
        if (courseRepository.count() == 0) {
            // 2 Foundation
            courseRepository.save(new Course("CSC 111", "Introduction to Computer Science", "Foundation", "Basic concepts"));
            courseRepository.save(new Course("CSC 121", "Introduction to Programming", "Foundation", "Problem solving with code"));

            // 5 Undergraduate
            courseRepository.save(new Course("CSC 211", "Data Structures", "Undergraduate", "Arrays, lists, trees"));
            courseRepository.save(new Course("CSC 212", "Object-Oriented Programming", "Undergraduate", "Classes, inheritance"));
            courseRepository.save(new Course("CSC 223", "Algorithms", "Undergraduate", "Sorting and searching"));
            courseRepository.save(new Course("CSC 312", "Operating Systems", "Undergraduate", "Processes and memory"));
            courseRepository.save(new Course("CSC 313", "Advanced OOP", "Undergraduate", "Design patterns"));

            // 4 Honours
            courseRepository.save(new Course("CSC 411", "Artificial Intelligence", "Honours", "Search and ML basics"));
            courseRepository.save(new Course("CSC 412", "Machine Learning", "Honours", "Supervised learning"));
            courseRepository.save(new Course("CSC 423", "Advanced Databases", "Honours", "NoSQL and big data"));
            courseRepository.save(new Course("CSC 424", "Honours Research Project", "Honours", "Individual project"));
        }
    }

    public List<Course> getAllCourses() { return courseRepository.findAll(); }
    public Optional<Course> getCourseById(Long id) { return courseRepository.findById(id); }
    public Course createCourse(Course course) { return courseRepository.save(course); }
    public Course updateCourse(Long id, Course updated) {
        return courseRepository.findById(id).map(course -> {
            course.setCourseCode(updated.getCourseCode());
            course.setName(updated.getName());
            course.setLevel(updated.getLevel());
            course.setDescription(updated.getDescription());
            return courseRepository.save(course);
        }).orElse(null);
    }
    public boolean deleteCourse(Long id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }
}