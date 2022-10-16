package com.example.demo.services;

import com.example.demo.data.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByScore(Integer min, Integer max) {
        return studentRepository.findAllByScoreBetween(min, max);
    }

    @Transactional
    public void changeScore(Long id, Integer delta) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setScore(student.getScore() + delta);
        studentRepository.save(student);
    }
}
