package com.example.springannotations.service.impl;

import com.example.springannotations.entity.Student;
import com.example.springannotations.respository.StudentRepository;
import com.example.springannotations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplV2 implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student add(Student student) {
        return null;
    }

    @Override
    public Optional<Student> getStudent(int id) {
        return Optional.empty();
    }

    @Override
    public List<Student> getStudents() {
        return null;
    }
}
