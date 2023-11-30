package com.reporthub.coreapis.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NbaDto{
    public ArrayList<Datum> data;
    public Meta meta;

    @Data
    public static class Datum{
        public int id;
        public String first_name;
        public int height_feet;
        public int height_inches;
        public String last_name;
        public String position;
        public Team team;
        public int weight_pounds;
    }

    @Data
    public static class Meta{
        public int total_pages;
        public int current_page;
        public int next_page;
        public int per_page;
        public int total_count;
    }

    @Data
    public static class Team{
        public int id;
        public String abbreviation;
        public String city;
        public String conference;
        public String division;
        public String full_name;
        public String name;
    }

}







