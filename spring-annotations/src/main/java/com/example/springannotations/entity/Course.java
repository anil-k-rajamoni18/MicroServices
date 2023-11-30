package com.example.springannotations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private Integer id;
    private String coursename;
    private String duration;

}
