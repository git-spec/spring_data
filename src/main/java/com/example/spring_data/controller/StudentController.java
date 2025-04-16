package com.example.spring_data.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data.model.Student;


@RestController
@RequestMapping("api/student")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        return List.of();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return null;
    }
}
