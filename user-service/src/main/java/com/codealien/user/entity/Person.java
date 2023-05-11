package com.codealien.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;

    public Person(String firstName, String lastName, String email, Long departId) {
        this.firstName = firstName; this.lastName = lastName;
        this.email = email;
        this.departmentId = departId;
    }
}
