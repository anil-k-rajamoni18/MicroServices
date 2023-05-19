package com.reporthub.coreapis.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String name;
    private long studentId;
    private String collegName;
    private double gpa;

    /*public Student(StudentBuilder studentBuilder) {
        this.name = studentBuilder.name;
        this.studentId = studentBuilder.studentId;
        this.collegName = studentBuilder.collegName;
        this.gpa = studentBuilder.gpa;
    }

    public static class StudentBuilder{
        private String name;
        private long studentId;
        private String collegName;
        private double gpa;

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder id(long studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentBuilder college(String collegName) {
            this.collegName = collegName;
            return this;
        }

        public StudentBuilder gpa(double gpa) {
            this.gpa = gpa;
            return this;
        }

        public Student build(){
            return new Student(this);
        }



    }*/



}
