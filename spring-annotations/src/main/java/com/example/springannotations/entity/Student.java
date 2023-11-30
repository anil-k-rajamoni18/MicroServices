package com.example.springannotations.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String name;
    String rollNo;
    String stream;
    String address;
    Float fee;

    @OneToMany(targetEntity = Course.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "sfk")
    List<Course> courseList;

}
