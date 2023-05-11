package com.example.springannotations.service;

import com.example.springannotations.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface StudentService {
    public Student add(Student student);
    public Optional<Student> getStudent(int id);
    public List<Student> getStudents();
}
