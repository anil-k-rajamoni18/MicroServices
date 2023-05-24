package com.reporthub.coreapis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo{
    private int userI;
    private int id;
    private String title;
    private Boolean completed;
}
