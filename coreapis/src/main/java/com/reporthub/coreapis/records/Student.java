package com.reporthub.coreapis.records;

import lombok.Builder;

@Builder
public record Student(Integer id,String name,double gpa, String collegeName) {
}

//@Builder
//public class Student{
//    private Integer id;
//    private String name;
//    private double gpa;
//    private String collegeName;
//}
