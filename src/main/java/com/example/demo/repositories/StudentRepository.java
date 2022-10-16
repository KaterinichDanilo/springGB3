package com.example.demo.repositories;

import com.example.demo.data.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByScoreBetween(Integer min, Integer max);

    @Query("SELECT s FROM Student s WHERE s.score < 23")
    List<Student> findStudentsLowScore();
}
