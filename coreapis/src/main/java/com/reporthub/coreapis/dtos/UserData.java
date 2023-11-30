package com.reporthub.coreapis.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
public class UserData{
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;

    @Data
    public static class Support{
        private String url;
        private String text;
    }

    @Data
    public static class User{
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

}






