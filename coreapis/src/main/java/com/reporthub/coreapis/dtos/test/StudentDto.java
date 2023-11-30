package com.reporthub.coreapis.dtos.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

//@ToString
//@Getter
//@JsonIgnoreProperties(ignoreUnknown = true)

//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
//@Setter

//@Data
//@AllArgsConstructor

//@Builder
//@Getter
//@ToString

@Builder
@Jacksonized
@ToString
@Getter
public class StudentDto {
    private String name;
    private String college;
    private int rank;
}
