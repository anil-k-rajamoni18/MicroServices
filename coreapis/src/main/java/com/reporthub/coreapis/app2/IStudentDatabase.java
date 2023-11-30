package com.reporthub.coreapis.app2;

import java.util.List;

public interface IStudentDatabase {

    List<Float> getStudentScores(String studentId);
    void updateStudentGrade(String id , String grade);
    String getGrade(String id);
}
