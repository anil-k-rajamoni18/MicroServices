package com.reporthub.coreapis.controller;

import com.reporthub.coreapis.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/core")
public class RootController {

    @GetMapping
    public String greet(){
        return "core api UP and RUNNING ....";

    }

    @GetMapping("/student")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(){

        return  Student.builder()
                .studentId(10051733096L)
                .name("Kumar Rajamoni")
                .collegName("NJIT")
                .gpa(4.2)
                .build();
    }

}
