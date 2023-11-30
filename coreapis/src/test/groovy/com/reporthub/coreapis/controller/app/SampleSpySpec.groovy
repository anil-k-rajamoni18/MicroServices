package com.reporthub.coreapis.controller.app

import com.reporthub.coreapis.app2.StudentDatabase
import com.reporthub.coreapis.app2.StudentGradeCalculator
import spock.lang.Specification

class SampleSpySpec extends Specification{

    //spy works on real objs
    def studentDatabase = Spy(StudentDatabase.class)
    def app = new StudentGradeCalculator(studentDatabase)

    def "sample spy test"(){
        when:
        app.calculateStudentGrade("123")
        then:
        1*studentDatabase.getGrade("123")
        0*studentDatabase.getStudentScores(_)
    }
}
