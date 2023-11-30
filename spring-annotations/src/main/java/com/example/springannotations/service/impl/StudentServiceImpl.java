package com.example.springannotations.service.impl;

import com.example.springannotations.entity.Student;
import com.example.springannotations.respository.StudentRepository;
import com.example.springannotations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public Student add(Student student) {return studentRepository.save(student);}

    @Override
    public Optional<Student> getStudent(int id) {return studentRepository.findById(id);}

    @Override
    public List<Student> getStudents() {return studentRepository.findAll();}
}
