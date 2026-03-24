package com.example.springbootassignment1_1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course code is required")
    @Column(nullable = false)
    private String courseCode;

    @NotBlank(message = "Course name is required")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Level is required")
    @Column(nullable = false)
    private String level;   // Foundation, Undergraduate, Honours

    private String description;

    public Course() {}
    public Course(String courseCode, String name, String level, String description) {
        this.courseCode = courseCode;
        this.name = name;
        this.level = level;
        this.description = description;
    }

    // GETTERS & SETTERS (Alt+Insert → select all)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}