package com.reporthub.coreapis.app2;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StudentGradeCalculator {

    //external dependency
    private IStudentDatabase database;

    public String calculateStudentGrade(String id){
        String grade;
        // check if grade is already there in database
        grade = database.getGrade(id);
        if(null != grade && !grade.isEmpty()){
            return grade;
        }

        List<Float> scoreLst = database.getStudentScores(id);
        Float totalScore = 0F;
        if(scoreLst != null){
            totalScore = scoreLst.stream().reduce(0F,(a,b)-> a+b);
        }
        if(totalScore > 90){
            grade = "A";
        }else if(totalScore > 80){
            grade = "B";
        }else {
            grade = "C";
        }
        database.updateStudentGrade(id,grade);
        return grade;
    }
}
