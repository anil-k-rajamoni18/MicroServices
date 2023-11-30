package com.reporthub.coreapis.app2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDatabase implements IStudentDatabase{

    private Map<String,List<Float>> scoreMap;
    private Map<String,String> gradeMap;

    public StudentDatabase(){
        this.scoreMap = new HashMap<>();
        this.gradeMap = new HashMap<>();

        scoreMap.put("123", List.of(40F,30F,30F));
        scoreMap.put("456", List.of(10F,10F,30F));

        gradeMap.put("123","C");
        gradeMap.put("456","A");
    }
    @Override
    public List<Float> getStudentScores(String studentId) {
        return scoreMap.get(studentId);
    }

    @Override
    public void updateStudentGrade(String id, String grade) {
        gradeMap.put(id,grade);
    }

    @Override
    public String getGrade(String id) {
        return gradeMap.get(id);
    }
}
