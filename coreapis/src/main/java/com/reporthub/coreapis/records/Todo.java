package com.reporthub.coreapis.records;

/*
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo{
    private int userI;
    private int id;
    private String title;
    private Boolean completed;
}
*/

public record Todo(Integer userId,Integer id,String title,boolean completed) {
}
