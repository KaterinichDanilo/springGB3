package com.example.demo.lesson7.controllers;

import com.example.demo.lesson7.data.Student;
import com.example.demo.lesson7.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    public StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/find/{id}")
    public Student findStudent(@PathVariable(name = "id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/students/between")
    public List<Student> findByScore(@RequestParam(name = "min") Integer min, @RequestParam(name = "max") Integer max) {
        return studentService.findByScore(min, max);
    }
}
