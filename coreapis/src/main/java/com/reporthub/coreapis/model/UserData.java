package com.reporthub.coreapis.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserData{
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;

}

@Data
class Support{
    private String url;
    private String text;
}


@Data
class User{
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}

